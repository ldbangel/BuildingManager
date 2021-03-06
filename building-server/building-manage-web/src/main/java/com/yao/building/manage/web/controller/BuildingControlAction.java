package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.yao.building.manage.dao.BuildingInfoDao;
import com.yao.building.manage.dao.BuildingRoomInfoDao;
import com.yao.building.manage.dao.EmployeeBuildingInfoDao;
import com.yao.building.manage.dao.PlaceDictDao;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.request.*;
import com.yao.building.manage.response.*;
import com.yao.building.manage.service.BuildingManageService;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.component.CommonService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 超级管理员界面
 */
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

    /**
     * 获取地址列表
     */
    @UserLoginToken
    @RequestMapping("getPlaceInfo")
    public List<PlaceEntryResponse> getPlaceInfos(@RequestBody GetPlaceInfoRequest request,
                                                  HttpServletRequest servletRequest){
        String token = servletRequest.getHeader("token");
        String employeeString  = JWT.decode(token).getAudience().get(0);
        Employee employee = JSONObject.parseObject(employeeString, Employee.class);
        if(employee == null){
            throw new RuntimeException("请重新登录");
        }

        if(request == null || request.getPId() == null || request.getPId() == 0){
            return null;
        }
        List<PlaceEntryResponse> responseList = new ArrayList<>();
        // 大于100000时为buildingId,这里直接查询buildingId所有的房间就行了
        if(request.getPId() > BUILDING_ID_START){
            BuildingRoomInfoExample example = new BuildingRoomInfoExample();
            BuildingRoomInfoExample.Criteria criteria = example.createCriteria();
            criteria.andBuildingIdEqualTo(request.getPId());
            List<BuildingRoomInfo> buildingRoomInfoList = buildingRoomInfoDao.selectByExample(example);
            if(CollectionUtils.isEmpty(buildingRoomInfoList)){
                return (List<PlaceEntryResponse>) CollectionUtils.EMPTY_COLLECTION;
            }
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

        PlaceDictExample pdExample = new PlaceDictExample();
        PlaceDictExample.Criteria pdCriteria = pdExample.createCriteria();
        pdCriteria.andIdEqualTo(request.getPId());
        pdCriteria.andStatusEqualTo(1);
        List<PlaceDict> pPlaceDictList = placeDictDao.selectByExample(pdExample);
        if(CollectionUtils.isEmpty(pPlaceDictList)){
            return (List<PlaceEntryResponse>) CollectionUtils.EMPTY_COLLECTION;
        }
        PlaceDict pPlaceDict = pPlaceDictList.get(0);
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
                        }).distinct().collect(Collectors.toList());
            }else if(pPlaceLevel == 2){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getCityId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getAreaId());
                            response.setPlaceName(buildingInfo.getAreaName());
                            return response;
                        }).distinct().collect(Collectors.toList());
            }else if(pPlaceLevel == 3){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getAreaId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getStreetId());
                            response.setPlaceName(buildingInfo.getStreetName());
                            return response;
                        }).distinct().collect(Collectors.toList());
            }else if(pPlaceLevel == 4){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getStreetId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getVillageId());
                            response.setPlaceName(buildingInfo.getVillageName());
                            return response;
                        }).distinct().collect(Collectors.toList());
            }else if(pPlaceLevel == 5){
                responseList = buildingInfoList.stream()
                        .filter(buildingInfo -> Objects.equals(buildingInfo.getVillageId(), pPlaceDict.getId()))
                        .map(buildingInfo -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(buildingInfo.getId());
                            response.setPlaceName(buildingInfo.getBuildingDesc());
                            return response;
                        }).distinct().collect(Collectors.toList());
            }
        }else if(employee.getEmployeeRole() == 1){   // 超级管理员
            if(pPlaceLevel >=1 && pPlaceLevel < 5){
                PlaceDictExample example = new PlaceDictExample();
                PlaceDictExample.Criteria criteria = example.createCriteria();
                criteria.andPIdEqualTo(request.getPId());
                criteria.andStatusEqualTo(1);
                List<PlaceDict> placeDictList = placeDictDao.selectByExample(example);
                responseList = placeDictList.stream()
                        .map(placeDict -> {
                            PlaceEntryResponse response = new PlaceEntryResponse();
                            response.setPlaceId(placeDict.getId());
                            response.setPlaceName(placeDict.getPlaceName());
                            return response;
                        }).distinct().collect(Collectors.toList());
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
                        }).distinct().collect(Collectors.toList());
            }
        }



        return  responseList;
    }

    /**
     * 租赁概览
     */
    @UserLoginToken
    @RequestMapping("getRoomsStatusInfo")
    public List<RoomStatusInfoResponse> getRoomsRentStatusInfo(@RequestBody GetRoomStatusInfoRequest request){
        List<RoomStatusInfoResponse> responseList = roomInfoService.getRoomStatusInfos(request);
        return responseList;
    }

    /**
     * 楼栋信息
     */
    @UserLoginToken
    @RequestMapping("getAllBuildingsInfo")
    public PageBean<BuildingBaseInfoResponse> getAllBuildingInfos(@RequestBody GetBuildingBaseInfoRequest request){
        PageBean<BuildingBaseInfoResponse> response = buildingManageService.getBuildingBaseInfo(request);
        return response;
    }

    /**
     * 具体楼栋信息
     */
    @UserLoginToken
    @RequestMapping("getBuildingInfoDetail")
    public BuildingBaseInfoResponse getBuildingInfoSimple(@RequestBody GetBuildingInfoDetailRequest request){
        BuildingBaseInfoResponse response = buildingManageService.getBuildingDetailInfo(request.getBuildingId());
        return response;
    }

    /**
     * 编辑楼栋信息
     */
    @UserLoginToken
    @RequestMapping("editBuildingInfo")
    public JSONObject editBuildingInfo(@RequestBody AddOrEditBuildingInfoRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.addOrEditBuildingBaseInfo(request);
        response.put("status", "success");
        return response;
    }

    /**
     * 获取房间信息
     */
    @UserLoginToken
    @RequestMapping("getAllRoomsInfo")
    public PageBean<RoomBaseInfoResponse> getAllRoomsInfo(@RequestBody GetRoomBaseInfoRequest request){
        PageBean<RoomBaseInfoResponse> response = buildingManageService.getRoomBaseInfo(request);
        return response;
    }

    /**
     * 获取房间详细信息--单个房间
     */
    @UserLoginToken
    @RequestMapping("getRoomInfoDetail")
    public RoomInfoResponse getRoomInfoDetail(GetRoomInfoDetailRequest request){
        RoomInfoResponse response = roomInfoService.getRoomBaseInfo(request.getRoomId());
        return response;
    }

    /**
     * 编辑房间信息
     */
    @UserLoginToken
    @RequestMapping("editRoomInfo")
    public JSONObject editRoomInfo(@RequestBody AddOrEditRoomInfoRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.addOrEditRoomBaseInfo(request);
        response.put("status", "success");
        return response;
    }

    /**
     * 获取楼栋--管理员关联关系信息
     */
    @UserLoginToken
    @RequestMapping("getBuildManagerInfos")
    public PageBean<BuildingAndEmployeeInfoResponse> getBuildingAndMangerInfos(@RequestBody GetBuildingAndEmployeeInfoRequest request){
        PageBean<BuildingAndEmployeeInfoResponse> response = employeeInfoService.getBuildingAndEmployeeInfos(request);
        return response;
    }

    /**
     * 获取楼栋--管理员信息详情
     */
    @UserLoginToken
    @RequestMapping("getManagerInfoDetail")
    public Employee getManagerInfoDetail(@RequestBody GetManagerInfoDetailRequest request){
        Employee employee = employeeInfoService.findEmployeeById(request.getEmployeeId());
//        BuildingAndEmployeeInfoResponse response = employeeInfoService.getBuildingEmployeeInfoSimple(request);
        return employee;
    }

    /**
     * 删除楼栋管理员
     */
    @UserLoginToken
    @RequestMapping("deleteBuildingManager")
    public JSONObject deleteBuildingManager(@RequestBody DeleteBuildingManagerRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.deleteBuildingManager(request);
        response.put("status", "success");
        return response;
    }

    /**
     * 新增楼栋管理员
     */
    @UserLoginToken
    @RequestMapping("addBuildingManager")
    public JSONObject addBuildingManager(@RequestBody AddBuildingManagerRequest request){
        JSONObject response = new JSONObject();
        buildingManageService.addBuildingManager(request);
        response.put("status", "success");
        return response;
    }

}
