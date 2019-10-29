package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.dao.PlaceDictDao;
import com.yao.building.manage.domain.PlaceDict;
import com.yao.building.manage.domain.PlaceDictExample;
import com.yao.building.manage.request.*;
import com.yao.building.manage.request.PageRequest.BaseRequest;
import com.yao.building.manage.response.BuildingAndEmployeeInfoResponse;
import com.yao.building.manage.response.BuildingBaseInfoResponse;
import com.yao.building.manage.response.RoomBaseInfoResponse;
import com.yao.building.manage.response.RoomStatusInfoResponse;
import com.yao.building.manage.service.BuildingManageService;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    @UserLoginToken
    @RequestMapping("getPlaceInfo")
    public List<PlaceDict> getPlaceInfos(@RequestBody GetPlaceInfoRequest request){
        PlaceDictExample placeDictExample = new PlaceDictExample();
        PlaceDictExample.Criteria placeDictCriteria = placeDictExample.createCriteria();
        placeDictCriteria.andPIdEqualTo(request.getPId());
        placeDictCriteria.andStatusEqualTo(1);
        List<PlaceDict> placeDictList = placeDictDao.selectByExample(placeDictExample);
        return  placeDictList;
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
