package com.yao.building.manage.dal;

import com.yao.building.manage.dao.RoomInfoDao;
import com.yao.building.manage.dao.RoomInfoWaterDao;
import com.yao.building.manage.domain.RoomInfo;
import com.yao.building.manage.domain.RoomInfoWater;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RoomInfoDal {
    @Autowired
    private RoomInfoDao roomInfoDao;
    @Autowired
    private RoomInfoWaterDao roomInfoWaterDao;

    public void insert(RoomInfo roomInfo){
        roomInfoDao.insertSelective(roomInfo);
        RoomInfoWater roomInfoWater = new RoomInfoWater();
        BeanUtils.copyProperties(roomInfo, roomInfoWater, "id");
        roomInfoWater.setIndex(roomInfo.getId());
        roomInfoWater.setModifyTime(new Date());
        roomInfoWaterDao.insertSelective(roomInfoWater);
    }

    public void  update(RoomInfo roomInfo){
        roomInfoDao.updateByPrimaryKeySelective(roomInfo);
        RoomInfoWater roomInfoWater = new RoomInfoWater();
        BeanUtils.copyProperties(roomInfo, roomInfoWater, "id");
        roomInfoWater.setIndex(roomInfo.getId());
        roomInfoWater.setModifyTime(new Date());
        roomInfoWaterDao.insertSelective(roomInfoWater);
    }
}
