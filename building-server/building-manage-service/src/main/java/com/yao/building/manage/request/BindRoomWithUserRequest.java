package com.yao.building.manage.request;

import lombok.Data;

import java.util.List;

@Data
public class BindRoomWithUserRequest {
    private Integer roomId;
    private Integer roomRent;
    private Integer waterNum;
    private Integer energyNum;
    private String  rentBeginTime;
    private List<UserBaseInfo> userBaseInfos;

    @Data
    public class UserBaseInfo{
        private String username;
        private String userMobile;
        private String userIdCard;
        private String idCardUrl1;
        private String idCardUrl2;
    }
}
