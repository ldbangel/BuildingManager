package com.yao.building.manage.request;

import com.yao.building.manage.request.PageRequest.UserBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindRoomWithUserRequest {
    private Integer roomId;
    private Integer roomRent;
    private Integer waterNum;
    private Integer energyNum;
    /**
     * 是否开通网络   0：不开通    1：开通
     */
    private Integer openInternet;

    /**
     * 水单价
     * 注意：只有房间是档口时需要传
     */
    private Integer waterUnit;

    /**
     * 电单价
     * 注意：只有房间是档口时需要传
     */
    private Integer energyUnit;
    private String  rentBeginTime;
    private List<UserBaseInfo> userBaseInfos;
}
