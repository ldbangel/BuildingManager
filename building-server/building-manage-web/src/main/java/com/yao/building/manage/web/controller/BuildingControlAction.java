package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.dao.BuildingInfoDao;
import com.yao.building.manage.dao.BuildingRoomInfoDao;
import com.yao.building.manage.dao.EmployeeBuildingInfoDao;
import com.yao.building.manage.dao.PlaceDictDao;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.request.*;
import com.yao.building.manage.request.PageRequest.BaseRequest;
import com.yao.building.manage.response.*;
import com.yao.building.manage.service.BuildingManageService;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.service.impl.CommonService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping("/total/control/")
@RestController
public class BuildingControlAction {
    @Autowired
    private BuildingManageService buildingManageService;
    @Autowired
    private RoomInfoService roomInfoService;
    @Autowired
    private EmployeeService employeeInfoService;
    @Autowired
    private PlaceDictDao placeDictDao;
    @Autowired
    private EmployeeBuildingInfoDao employeeBuildingInfoDao;
    @Autowired
    private BuildingRoomInfoDao buildingRoomInfoDao;
    @Autowired
    private CommonService commonService;
    @Autowired
    private BuildingInfoDao buildingInfoDao;
    private static final int BUILDING_ID_START = 100000;

//    @UserLoginToken
    @RequestMapping("getPlaceInfo")
    public List<PlaceEntryResponse> getPlaceInfos(@RequestBody GetPlaceInfoRequest request,
                                                  HttpServletRequest servletRequest){
        Employee employee = (Employee) servletRequest.getSession().getAttribute("employee");
        if(employee == null){
            throw new RuntimeException();
        }
        List<PlaceEntryResponse> responseList = new ArrayList<>();
        // 大于100000时为buildingId,这里直接查询buildingId所有的房间就行了
        if(request.getPId() > BUILDING_ID_START){
            BuildingRoomInfoExample example = new BuildingRoomInfoExample();
            BuildingRoomInfoExample.Criteria criteria = example.createCriteria();
            criteria.andBuildingIdEqualTo(request.getPId());
            List<BuildingRoomInfo> buildingRoomInfoList = buildingRoomInfoDao.selectByExample(example);
            List<Integer> roomIdList = buildingRoomInfoList.stream().map(buildingRoomInfo -> buildingRoomInfo.getRoomId()).collect(Collectors.toList());
            List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(roomIdList, null);
            responseList = roomInfoList.stream()
                    .map(roomInfo -> {
                        PlaceEntryResponse response = new PlaceEntryResponse();
                        response.setPlaceId(roomInfo.getId());
                        response.setPlaceName(roomInfo.getRoomNo().toString());
                        return response;
                    }).collect(Collectors.toList());
            return responseList;
        }
        PlaceDict pPlaceDict = placeDictDao.selectByPrimaryKey(request.getPId());
        int pPlaceLevel = pPlaceDict.getPlaceLevel();


        // 普通楼栋管理员
        if(employee.getEmployeeRole() == 2){
            EmployeeBuildingInfoExample example = new EmployeeBuildingInfoExample();
            EmployeeBuildingInfoExample.Criteria criteria = example.createCriteria();
            criteria.andEmployeeIdEqualTo(employee.getId());
            criteria.andStatusEqualTo(1);
            List<EmployeeBuildingInfo> employeeBuildingInfos = employeeBuildingInfoDao.selectByExample(example);
            List<Integer> buildingIds = employeeBuildingInfos.stream()
                    .map(employeeBuildingInfo -> employeeBuildingInfo.getBuildingId())
                    .distinct().collect(Collectors.toList());

            BuildingInfoExample buildingInfoExample = new BuildingInfoExample();
            BuildingInfoExample.Criteria buildingCriteria = buildingInfoExample.createCriteria();
            buildingCriteria.andIdIn(buildingIds);
            List<BuildingInfo> buildingInfoList = buildingInfoDao.selectByExample(buildingInfoExample);

            // 正常数据--非楼栋及房间下拉列表查询
            if(pPlaceLevel == 1){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getProvinceId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getCityId());
                            response.setPlaceName(buildingInfo.getCityName());
                            return response;
                        }).collect(Collectors.toList());
            }else if(pPlaceLevel == 2){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getCityId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getAreaId());
                            response.setPlaceName(buildingInfo.getAreaName());
                            return response;
                        }).collect(Collectors.toList());
            }else if(pPlaceLevel == 3){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getAreaId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getStreetId());
                            response.setPlaceName(buildingInfo.getStreetName());
                            return response;
                        }).collect(Collectors.toList());
            }else if(pPlaceLevel == 4){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getStreetId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getVillageId());
                            response.setPlaceName(buildingInfo.getVillageName());
                            return response;
                        }).collect(Collectors.toList());
            }else if(pPlaceLevel == 5){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getVillageId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getId());
                            response.setPlaceName(buildingInfo.getBuildingDesc());
                            return response;
                        }).collect(Collectors.toList());
            }
        }else if(employee.getEmployeeRole() == 1){   // 超级管理员
            if(pPlaceLevel >=1 && pPlaceLevel < 5){
                PlaceDictExample example = new PlaceDictExample();
                PlaceDictExample.Criteria criteria = example.createCriteria();
                criteria.andPIdEqualTo(request.getPId());
                List<PlaceDict> placeDictList = placeDictDao.selectByExample(example);
                responseList = placeDictList.stream()
                        .map(placeDict -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(placeDict.getId());
                            response.setPlaceName(placeDict.getPlaceName());
                            return response;
                        })
                        .collect(Collectors.toList());
            }else if(pPlaceLevel == 5){
                BuildingInfoExample example = new BuildingInfoExample();
                BuildingInfoExample.Criteria criteria = example.createCriteria();
                criteria.andVillageIdEqualTo(request.getPId());
                List<BuildingInfo> buildingInfoList = buildingInfoDao.selectByExample(example);
                responseList = buildingInfoList.stream()
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getId());
                            response.setPlaceName(buildingInfo.getBuildingDesc());
                            return response;
                        }).collect(Collectors.toList());
            }
        }



        return  responseList;
    }

    @RequestMapping("getRoomsStatusInfo")
    public List<RoomStatusInfoResponse> getRoomsRentStatusInfo(@RequestBody GetRoomStatusInfoRequest request){
        List<RoomStatusInfoResponse> responseList = roomInfoService.getRoomStatusInfos(request);
        return responseList;
    }

    @RequestMapping("getAllBuildingsInfo")
    public PageBean<BuildingBaseInfoResponse> getAllBuildingInfos(@RequestBody GetBuildingBaseInfoRequest request){
        PageBean<BuildingBaseInfoResponse> response = buildingManageService.getBuildingBaseInfo(request);
        return response;
    }

    @RequestMapping("getBuildingInfoDetail")
    public BuildingBaseInfoResponse getBuildingInfoSimple(@RequestBody GetBuildingInfoDetailRequest request){
        BuildingBaseInfoResponse response = buildingManageService.getBuildingDetailInfo(request.getBuildingId());
        return response;
    }

    @RequestMapping("editBuildingInfo")
    public JSONObject editBuildingInfo(@RequestBody AddOrEditBuildingInfoRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.addOrEditBuildingBaseInfo(request);
        response.put("status", "success");
        return response;
    }

    @RequestMapping("getAllRoomsInfo")
    public PageBean<RoomBaseInfoResponse> getAllRoomsInfo(@RequestBody GetRoomBaseInfoRequest request){
        PageBean<RoomBaseInfoResponse> response = buildingManageService.getRoomBaseInfo(request);
        return response;
    }

    @RequestMapping("editRoomInfo")
    public JSONObject editRoomInfo(@RequestBody AddOrEditRoomInfoRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.addOrEditRoomBaseInfo(request);
        response.put("status", "success");
        return response;
    }

    @RequestMapping("getBuildManagerInfos")
    public PageBean<BuildingAndEmployeeInfoResponse> getBuildingAndMangerInfos(@RequestBody GetBuildingAndEmployeeInfoRequest request){
        PageBean<BuildingAndEmployeeInfoResponse> response = employeeInfoService.getBuildingAndEmployeeInfos(request);
        return response;
    }

    @RequestMapping("getBuildManagerInfoDetail")
    public BuildingAndEmployeeInfoResponse getBuildManagerInfoDetail(@RequestBody BaseRequest request){
        BuildingAndEmployeeInfoResponse response = employeeInfoService.getBuildingEmployeeInfoSimple(request);
        return response;
    }

}
