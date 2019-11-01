package com.yao.building.manage.request;

import com.yao.building.manage.request.PageRequest.BaseRequest;
import lombok.Data;

@Data
public class GetHistoryUserInfoRequest extends BaseRequest {
    private String username;
    private String userMobile;
    private String userIdCard;
}
