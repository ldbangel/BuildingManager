package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.domain.UserInfo;
import com.yao.building.manage.request.*;
import com.yao.building.manage.response.AbleCancelRoomResponse;
import com.yao.building.manage.response.AbleToRentRoomResponse;
import com.yao.building.manage.response.RoomRentBaseInfoResponse;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.vo.RoomUserInfoResponse;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 楼栋管理员界面
 */
@RestController
@RequestMapping("/building/manager")
public class ManagerAction {
    @Autowired
    private RoomInfoService roomInfoService;

    /**
     * 获取房间信息
     */
    @UserLoginToken
    @RequestMapping("getRoomInfos")
    public List<RoomUserInfoResponse> getManageRoomUserInfo(@RequestBody GetRoomUserInfoRequest request){
        List<RoomUserInfoResponse> responseList = roomInfoService.getRoomUserInfo(request);
        return responseList;
    }

    /**
     * 获取租客详情
     */
    @UserLoginToken
    @RequestMapping("getCustomerDetailInfo")
    public UserInfo getCustomerDetailInfo(@RequestBody GetUserDetailInfoRequest request,
                                          HttpServletRequest servletRequest){
        return roomInfoService.getUserDetailInfo(request);
    }

    /**
     * 获取房间数据
     */
    @UserLoginToken
    @RequestMapping("getRoomRentDataInfos")
    public List<RoomRentBaseInfoResponse> getRoomBaseDataInfoOfMonth(@RequestBody GetRoomRentBaseInfoRequest request){
        List<RoomRentBaseInfoResponse> responses = roomInfoService.getRoomRentBaseInfoOfMonth(request);
        return responses;
    }

    /**
     * 新增房间数据记录
     */
    @UserLoginToken
    @RequestMapping("addRoomRentDataInfo")
    public JSONObject addRoomRentBaseInfoOfMonth(@RequestBody AddRoomRentBaseInfoRequest request){
        JSONObject response = new JSONObject();
        response.put("status", "fail");
        int result = roomInfoService.addRoomRentBaseInfo(request);
        if(result > 0){
            response.put("status", "success");
            response.put("resultId", result);
        }

        return response;
    }

    /**
     * 获取可退租的房间信息
     */
    @UserLoginToken
    @RequestMapping("getAbleCancelRoomInfos")
    public PageBean<AbleCancelRoomResponse> getAllAbleCancelRentRoomInfos(@RequestBody GetAllAbleToCancelRoomRequest request){
        PageBean<AbleCancelRoomResponse> pageBean = roomInfoService.getAllAbleToCancelRoomInfo(request);
        return pageBean;
    }

    /**
     * 退租操作
     */
    @UserLoginToken
    @RequestMapping("cancelRoomRent")
    public JSONObject cancelRoomRent(@RequestBody CancelRoomRentRequest request){
        JSONObject response = new JSONObject();
        response.put("status", "fail");
        roomInfoService.cancelRoomRent(request);
        response.put("status", "success");
        return response;
    }

    /**
     * 获取可租赁房间信息
     */
    @UserLoginToken
    @RequestMapping("getAbleRentRoomInfos")
    public PageBean<AbleToRentRoomResponse> getAllAbleRentRoomInfos(@RequestBody GetAllAbleToRentRoomRequest request){
        PageBean<AbleToRentRoomResponse> response = roomInfoService.getAllAbleToRentRoomInfo(request);
        return response;
    }

    /**
     * 出租操作
     */
    @UserLoginToken
    @RequestMapping("rentRoom")
    public JSONObject rentRoom(@RequestBody BindRoomWithUserRequest request){
        roomInfoService.bindRoomWithUserInfo(request);
        JSONObject response = new JSONObject();
        response.put("status", "success");
        return response;
    }
}
