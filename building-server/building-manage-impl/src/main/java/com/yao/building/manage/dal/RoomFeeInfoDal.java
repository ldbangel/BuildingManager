package com.yao.building.manage.dal;

import com.yao.building.manage.dao.RoomFeeDao;
import com.yao.building.manage.dao.RoomFeeWaterDao;
import com.yao.building.manage.domain.RoomFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomFeeInfoDal {
    @Autowired
    private RoomFeeDao roomFeeDao;

    @Autowired
    private RoomFeeWaterDao roomFeeWaterDao;

    public void insert(RoomFee roomFee){

    }

    public void update(RoomFee roomFee){

    }
}
