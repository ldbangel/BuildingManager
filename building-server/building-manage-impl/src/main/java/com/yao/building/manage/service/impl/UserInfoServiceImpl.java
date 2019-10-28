package com.yao.building.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.dao.UserInfoDao;
import com.yao.building.manage.domain.UserInfo;
import com.yao.building.manage.domain.UserInfoExample;
import com.yao.building.manage.request.PageRequest.GetUserInfoOfPageRequest;
import com.yao.building.manage.service.UserInfoService;
import com.yao.building.manage.vo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public void queryUserBaseInfo() {

    }

    @Override
    public PageBean<UserInfo> getUserInfoList(GetUserInfoOfPageRequest request) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
        userInfoCriteria.andIdIn(request.getUserIds());
        userInfoCriteria.andStatusEqualTo(request.getStatus());
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<UserInfo> userInfoList = userInfoDao.selectByExample(userInfoExample);
        PageBean<UserInfo> pageBean = new PageBean<>(userInfoList);
        return pageBean;
    }
}
