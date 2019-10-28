package com.yao.building.manage.response;

import lombok.Data;

@Data
public class UserBaseAndAddressInfoResponse extends BaseResponse{
    private Integer userId;
    private Integer roomNo;
    private String status;
    private String username;
    private String userMobile;
    private String userIdCard;
    private String rentBeginTime;
    private String rentEndTime;
}
