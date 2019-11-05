package com.yao.building.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.dao.EmployeeBuildingInfoDao;
import com.yao.building.manage.dao.EmployeeDao;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.request.GetBuildingAndEmployeeInfoRequest;
import com.yao.building.manage.request.ModifyEmployeeInfoRequest;
import com.yao.building.manage.request.PageRequest.BaseRequest;
import com.yao.building.manage.request.QueryEmployeeInfSimpleRequest;
import com.yao.building.manage.response.BaseResponse;
import com.yao.building.manage.response.BuildingAndEmployeeInfoResponse;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.vo.EmployeeEntry;
import com.yao.building.manage.vo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service("employeeInfoService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CommonService commonService;
    @Autowired
    private EmployeeBuildingInfoDao employeeBuildingInfoDao;
    @Autowired
    private BuildingInfoDao buildingInfoDao;

    @Override
    public Employee queryEmployeeInfoSimple(QueryEmployeeInfSimpleRequest request) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andStatusEqualTo(1);
        if(StringUtils.isNotEmpty(request.getEmployeeMobile())){
            criteria.andEmployeeMobileEqualTo(request.getEmployeeMobile());
        }
        if(request.getEmployeeId() != null && request.getEmployeeId() != 0){
            criteria.andIdEqualTo(request.getEmployeeId());
        }

        List<Employee> employees = employeeDao.selectByExample(employeeExample);
        if(CollectionUtils.isEmpty(employees)){
            log.info("员工信息不存在，mobile = {}, id = {}", request.getEmployeeMobile(), request.getEmployeeId());
            return null;
        }
        Employee employee = employees.get(0);
        return employee;
    }

    @Override
    public int modifyEmployeeInfo(ModifyEmployeeInfoRequest request) {
        Employee employee = new Employee();
        employee.setId(request.getEmployeeId());
        employee.setPassword(request.getPassword());

        int result = employeeDao.updateByPrimaryKeySelective(employee);

        return result;
    }

    @Override
    public PageBean<BuildingAndEmployeeInfoResponse> getBuildingAndEmployeeInfos(GetBuildingAndEmployeeInfoRequest request) {
        PageBean<BuildingAndEmployeeInfoResponse> responsePage = new PageBean<>();

        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
        List<Integer> buildingIds = baseResponseList.stream().map(baseResponse -> baseResponse.getBuildingId()).distinct().collect(Collectors.toList());

        BuildingInfoExample buildingInfoExample = new BuildingInfoExample();
        BuildingInfoExample.Criteria buildingInfoCriteria = buildingInfoExample.createCriteria();
        buildingInfoCriteria.andIdIn(buildingIds);
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<BuildingInfo> buildingInfoList  = buildingInfoDao.selectByExample(buildingInfoExample);
        PageBean<BuildingInfo> pageBean = new PageBean<>(buildingInfoList);

        List<BuildingAndEmployeeInfoResponse> responseList = buildingInfoList.stream()
                .map(buildingInfo -> {
                    BuildingAndEmployeeInfoResponse response = new BuildingAndEmployeeInfoResponse();
                    response.setBuildingId(buildingInfo.getId());
                    response.setBuildingName(buildingInfo.getBuildingDesc());
                    response.setAreaName(buildingInfo.getAreaName());
                    response.setCityName(buildingInfo.getCityName());
                    response.setStreetName(buildingInfo.getStreetName());
                    response.setVillageName(buildingInfo.getVillageName());
                    return response;
                })
                .collect(Collectors.toList());

        List<Integer> validBuildingIds = buildingInfoList.stream().map(buildingInfo -> buildingInfo.getId()).collect(Collectors.toList());

        EmployeeBuildingInfoExample empBuildInfoExample = new EmployeeBuildingInfoExample();
        EmployeeBuildingInfoExample.Criteria empBuildInfoCriteria = empBuildInfoExample.createCriteria();
        empBuildInfoCriteria.andBuildingIdIn(validBuildingIds);
        empBuildInfoCriteria.andStatusEqualTo(1);
        List<EmployeeBuildingInfo> employeeBuildingInfos= employeeBuildingInfoDao.selectByExample(empBuildInfoExample);

        // 这里有待考证
        /*responseList.stream()
                .map(response -> employeeBuildingInfos.stream()
                        .filter(employeeBuildingInfo -> Objects.equals(employeeBuildingInfo.getBuildingId(), response.getBuildingId()))
                        .map(employeeBuildingInfo -> {
                            EmployeeEntry employeeEntry = new EmployeeEntry();
                            employeeEntry.setEmployeeId(employeeBuildingInfo.getEmployeeId());
                            response.getEmployeeEntries().add(employeeEntry);
                            return response;
                        }))
                .collect(Collectors.toList());*/

        responseList.stream()
                .forEach(response -> response.setEmployeeEntries(
                        employeeBuildingInfos.stream()
                                .filter(employeeBuildingInfo -> Objects.equals(employeeBuildingInfo.getBuildingId(), response.getBuildingId()))
                                .map(employeeBuildingInfo -> {
                                    EmployeeEntry employeeEntry = new EmployeeEntry();
                                    employeeEntry.setEmployeeId(employeeBuildingInfo.getEmployeeId());
                                    return employeeEntry;
                                }).collect(Collectors.toList())));

        List<Integer> employeeIds = employeeBuildingInfos.stream().map(employeeBuildingInfo -> employeeBuildingInfo.getEmployeeId()).collect(Collectors.toList());

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
        employeeCriteria.andIdIn(employeeIds);
        employeeCriteria.andStatusEqualTo(1);
        List<Employee> employeeList = employeeDao.selectByExample(employeeExample);

        // 这里有待考证
        responseList.stream()
                .map(response -> response.getEmployeeEntries().stream()
                        .map(employeeEntry -> employeeList.stream()
                                .filter(employee -> Objects.equals(employee.getId(), employeeEntry.getEmployeeId()))
                                .findFirst()
                                .map(employee -> {
                                    employeeEntry.setEmployeeName(employee.getEmployeeName());
                                    return employeeEntry;
                                }).orElse(employeeEntry))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        BeanUtils.copyProperties(pageBean, responsePage);
        responsePage.setList(responseList);
        return responsePage;
    }

    @Override
    public BuildingAndEmployeeInfoResponse getBuildingEmployeeInfoSimple(BaseRequest request) {
        if(request == null || request.getBuildingId() == null || request.getBuildingId() == 0){
            return null;
        }
        BuildingInfo buildingInfo = buildingInfoDao.selectByPrimaryKey(request.getBuildingId());
        BuildingAndEmployeeInfoResponse response = new BuildingAndEmployeeInfoResponse();
        BeanUtils.copyProperties(buildingInfo, response);
        response.setBuildingName(buildingInfo.getBuildingDesc());

        EmployeeBuildingInfoExample ebInfoExample = new EmployeeBuildingInfoExample();
        EmployeeBuildingInfoExample.Criteria ebInfoCriteria = ebInfoExample.createCriteria();
        ebInfoCriteria.andBuildingIdEqualTo(buildingInfo.getId());
        ebInfoCriteria.andStatusEqualTo(1);
        List<EmployeeBuildingInfo> employeeBuildingInfoList = employeeBuildingInfoDao.selectByExample(ebInfoExample);

        response.setEmployeeEntries(employeeBuildingInfoList.stream()
                .map(employeeBuildingInfo -> {
                    EmployeeEntry employeeEntry = new EmployeeEntry();
                    employeeEntry.setEmployeeId(employeeBuildingInfo.getEmployeeId());
                    return employeeEntry;
                })
                .collect(Collectors.toList()));

        List<Integer> employeeIds = employeeBuildingInfoList.stream().map(employeeBuildingInfo -> employeeBuildingInfo.getEmployeeId()).collect(Collectors.toList());

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
        employeeCriteria.andIdIn(employeeIds);
        employeeCriteria.andStatusEqualTo(1);
        List<Employee> employeeList = employeeDao.selectByExample(employeeExample);


        response.getEmployeeEntries().stream()
                .map(employeeEntry -> employeeList.stream()
                        .filter(employee -> Objects.equals(employee.getId(), employeeEntry.getEmployeeId()))
                        .findFirst()
                        .map(employee -> {
                            employeeEntry.setEmployeeName(employee.getEmployeeName());
                            return employeeEntry;
                        }).orElse(employeeEntry))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = employeeDao.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public Employee findEmployeeByMobile(Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeMobileEqualTo(employee.getEmployeeMobile());
        criteria.andStatusEqualTo(1);
        List<Employee> employeeList = employeeDao.selectByExample(example);
        if(employeeList == null){
            return null;
        }
        return employeeList.get(0);
    }
}
