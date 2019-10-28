package com.yao.building.manage.service;

import com.yao.building.manage.domain.UserInfo;
import com.yao.building.manage.request.PageRequest.GetUserInfoOfPageRequest;
import com.yao.building.manage.vo.PageBean;

public interface UserInfoService {
    /**
     * 获取用户基本信息
     */
    public void queryUserBaseInfo();

    /**
     * 获用户基本信息，可支持分页查询
     */
    PageBean<UserInfo> getUserInfoList(GetUserInfoOfPageRequest request);

    /**
     *
     */

}
