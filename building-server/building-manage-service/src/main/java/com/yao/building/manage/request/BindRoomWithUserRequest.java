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
    private String  rentBeginTime;
    private List<UserBaseInfo> userBaseInfos;
}
