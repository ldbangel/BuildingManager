package com.yao.building.manage.response;

import lombok.Data;

@Data
public class AbleCancelRoomResponse extends BaseResponse{
    private Integer userId;
    private Integer roomNo;
    private String username;
    private String userMobile;
}
