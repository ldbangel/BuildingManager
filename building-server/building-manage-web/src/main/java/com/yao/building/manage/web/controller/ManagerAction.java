package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.domain.UserInfo;
import com.yao.building.manage.request.*;
import com.yao.building.manage.response.AbleCancelRoomResponse;
import com.yao.building.manage.response.AbleToRentRoomResponse;
import com.yao.building.manage.response.RoomRentBaseInfoResponse;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.vo.RoomUserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/building/manager")
public class ManagerAction {
    @Autowired
    private RoomInfoService roomInfoService;

    @RequestMapping("getRoomInfos")
    public List<RoomUserInfoResponse> getManageRoomUserInfo(@RequestBody GetRoomUserInfoRequest request,
                                                            HttpServletRequest servletRequest){
        List<RoomUserInfoResponse> responseList = roomInfoService.getRoomUserInfo(request);
        return responseList;
    }

    @RequestMapping("getCustomerDetailInfo")
    public UserInfo getCustomerDetailInfo(@RequestBody GetUserDetailInfoRequest request,
                                          HttpServletRequest servletRequest){
        return roomInfoService.getUserDetailInfo(request);
    }

    @RequestMapping("getRoomRentDataInfos")
    public List<RoomRentBaseInfoResponse> getRoomBaseDataInfoOfMonth(@RequestBody  GetRoomRentBaseInfoRequest request){
        List<RoomRentBaseInfoResponse> responses = roomInfoService.getRoomRentBaseInfoOfMonth(request);
        return responses;
    }

    @RequestMapping("addRoomRentDataInfo")
    public JSONObject addRoomRentBaseInfoOfMonth(@RequestBody AddRoomRentBaseInfoRequest request){
        JSONObject response = new JSONObject();
        response.put("status", "fail");
        /*AddRoomRentBaseInfoRequest request = new AddRoomRentBaseInfoRequest();
        request.setRoomId(1000001);
        request.setEnergyNum(1300);
        request.setWaterNum(120);
        request.setReadTime("2019-10-10 00:00:00");*/
        int result = roomInfoService.addRoomRentBaseInfo(request);
        if(result > 0){
            response.put("status", "success");
            response.put("resultId", result);
        }

        return response;
    }

    @RequestMapping("getAbleCancelRoomInfos")
    public List<AbleCancelRoomResponse> getAllAbleCancelRentRoomInfos(@RequestBody GetAllAbleToCancelRoomRequest request){
        List<AbleCancelRoomResponse> responseList = roomInfoService.getAllAbleToCancelRoomInfo(request);
        return responseList;
    }

    @RequestMapping("cancelRoomRent")
    public JSONObject cancelRoomRent(@RequestBody CancelRoomRentRequest request){
        JSONObject response = new JSONObject();
        response.put("status", "fail");
        roomInfoService.cancelRoomRent(request);
        response.put("status", "success");
        return response;
    }

    @RequestMapping("getAbleRentRoomInfos")
    public List<AbleToRentRoomResponse> getAllAbleRentRoomInfos(@RequestBody GetAllAbleToRentRoomRequest request){
        List<AbleToRentRoomResponse> responseList = roomInfoService.getAllAbleToRentRoomInfo(request);
        return responseList;
    }

    @RequestMapping("rentRoom")
    public JSONObject rentRoom(@RequestBody BindRoomWithUserRequest request){
        roomInfoService.bindRoomWithUserInfo(request);
        JSONObject response = new JSONObject();
        response.put("status", "success");
        return response;
    }
}
