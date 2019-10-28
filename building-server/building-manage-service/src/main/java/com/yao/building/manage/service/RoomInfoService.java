package com.yao.building.manage.service;

import com.yao.building.manage.domain.UserInfo;
import com.yao.building.manage.request.*;
import com.yao.building.manage.request.PageRequest.GetHistoryUserInfoRequest;
import com.yao.building.manage.response.*;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.vo.RoomUserInfoResponse;

import java.util.List;

/**
 * 楼栋管理员相关的操作
 */
public interface RoomInfoService {
    /**
     * 房间信息查询，可按照楼栋、房间查询
     * @param request
     * @return
     */
    List<RoomUserInfoResponse> getRoomUserInfo(GetRoomUserInfoRequest request);

    /**
     *  租房人的具体信息查询
     * @param request
     * @return
     */
    UserInfo getUserDetailInfo(GetUserDetailInfoRequest request);

    /**
     * 获取某个房间的每月水电、房租信息
     * @param request
     * @return
     */
    List<RoomRentBaseInfoResponse> getRoomRentBaseInfoOfMonth(GetRoomRentBaseInfoRequest request);

    /**
     * 新增房间水电记录数据
     * @param request
     * @return
     */
    int addRoomRentBaseInfo(AddRoomRentBaseInfoRequest request);

    /**
     * 房间退租操作
     */
    void cancelRoomRent(CancelRoomRentRequest request);

    /**
     * 获取可退租的房间信息
     * @param request
     * @return
     */
    List<AbleCancelRoomResponse> getAllAbleToCancelRoomInfo(GetAllAbleToCancelRoomRequest request);

    /**
     * 获取可出租的房间信息
     */
    List<AbleToRentRoomResponse> getAllAbleToRentRoomInfo(GetAllAbleToRentRoomRequest request);

    /**
     * 房间出租
     */
    int bindRoomWithUserInfo(BindRoomWithUserRequest request);

    /**
     * 获取房间的租赁状态信息
     * 租赁概览
     */
    List<RoomStatusInfoResponse> getRoomStatusInfos(GetRoomStatusInfoRequest request);

    /**
     * 获取房间以及房间数据信息
     * 房间历史数据
     */
    PageBean<RoomAndDataInfoResponse> getRoomAndDataInfo(GetRoomAndDataInfoRequest request);


    /**
     * 获取租客信息以及住址信息
     * 租客历史数据
     */
    PageBean<UserBaseAndAddressInfoResponse> getUserBaseAndAddressInfo(GetHistoryUserInfoRequest request);
}
