package com.yao.building.manage.dal;

import com.yao.building.manage.dao.RoomUserInfoDao;
import com.yao.building.manage.dao.RoomUserInfoWaterDao;
import com.yao.building.manage.domain.RoomUserInfo;
import com.yao.building.manage.domain.RoomUserInfoWater;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RoomUserInfoDal {
    @Autowired
    private RoomUserInfoDao roomUserInfoDao;
    @Autowired
    private RoomUserInfoWaterDao roomUserInfoWaterDao;

    public void insert(RoomUserInfo roomUserInfo){
        roomUserInfoDao.insertSelective(roomUserInfo);
        RoomUserInfoWater roomUserInfoWater = new RoomUserInfoWater();
        BeanUtils.copyProperties(roomUserInfo, roomUserInfoWater, "id");
        roomUserInfoWater.setIndex(roomUserInfo.getId());
        roomUserInfoWater.setModifyTime(new Date());
        roomUserInfoWaterDao.insertSelective(roomUserInfoWater);
    }
}
