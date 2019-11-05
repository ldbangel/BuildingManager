package com.yao.building.manage.vo;

import com.yao.building.manage.response.BaseResponse;
import lombok.Data;

@Data
public class RoomUserInfoResponse extends BaseResponse {
    private Integer userId;
    private String rentStatus;
    private String username;
    private String userMobile;
    private String userIdCard;
    private String rentBeginTime;


}
