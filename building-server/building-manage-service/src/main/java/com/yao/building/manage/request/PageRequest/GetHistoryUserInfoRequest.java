package com.yao.building.manage.request.PageRequest;

import lombok.Data;

@Data
public class GetHistoryUserInfoRequest extends BaseRequest {
    private Integer roomId;
    /**
     * 租客状态  0：退租   1：在租
     */
    private Integer status;
    private String username;
    private String userMobile;
    private String userIdCard;
}
