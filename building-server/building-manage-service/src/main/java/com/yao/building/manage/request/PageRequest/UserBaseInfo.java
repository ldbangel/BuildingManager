package com.yao.building.manage.request.PageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseInfo {
    private String username;
    private String userMobile;
    private String userIdCard;
    private String idCardUrl1;
    private String idCardUrl2;
}
