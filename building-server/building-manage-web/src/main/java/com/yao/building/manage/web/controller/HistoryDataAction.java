package com.yao.building.manage.web.controller;

import com.yao.building.manage.request.GetHistoryUserInfoRequest;
import com.yao.building.manage.request.GetRoomAndDataInfoRequest;
import com.yao.building.manage.response.RoomAndDataInfoResponse;
import com.yao.building.manage.response.UserBaseAndAddressInfoResponse;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/building/history/")
@RestController
public class HistoryDataAction {
    @Autowired
    private RoomInfoService roomInfoService;

    @UserLoginToken
    @RequestMapping("getRoomsInfo")
    public PageBean<RoomAndDataInfoResponse> getRoomHistoryInfo(@RequestBody GetRoomAndDataInfoRequest request){
        PageBean<RoomAndDataInfoResponse> response = roomInfoService.getRoomAndDataInfo(request);
        return response;
    }

    @UserLoginToken
    @RequestMapping("getUsersInfo")
    public PageBean<UserBaseAndAddressInfoResponse> getHistoryUserInfo(@RequestBody GetHistoryUserInfoRequest request){
        PageBean<UserBaseAndAddressInfoResponse> response = roomInfoService.getUserBaseAndAddressInfo(request);
        return response;
    }
}
