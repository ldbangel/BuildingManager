package com.yao.building.manage.dal;

import com.yao.building.manage.dao.BuildingInfoDao;
import com.yao.building.manage.dao.BuildingInfoWaterDao;
import com.yao.building.manage.domain.BuildingInfo;
import com.yao.building.manage.domain.BuildingInfoWater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class BuildingInfoDal {
    @Autowired
    private BuildingInfoDao buildingInfoDao;

    @Autowired
    private BuildingInfoWaterDao buildingInfoWaterDao;

    public void insert(BuildingInfo buildingInfo){
        buildingInfoDao.insertSelective(buildingInfo);
        BuildingInfoWater buildingInfoWater = new BuildingInfoWater();
        BeanUtils.copyProperties(buildingInfo, buildingInfoWater, "id");
        buildingInfoWater.setIndex(buildingInfo.getId());
        buildingInfoWater.setModifyTime(new Date());
        buildingInfoWaterDao.insertSelective(buildingInfoWater);
    }

    public void update(BuildingInfo buildingInfo){
        buildingInfoDao.updateByPrimaryKeySelective(buildingInfo);
        BuildingInfo newBuildingInfo = buildingInfoDao.selectByPrimaryKey(buildingInfo.getId());
        BuildingInfoWater buildingInfoWater = new BuildingInfoWater();
        BeanUtils.copyProperties(newBuildingInfo, buildingInfoWater, "id");
        buildingInfoWater.setIndex(buildingInfo.getId());
        buildingInfoWater.setModifyTime(new Date());
        buildingInfoWaterDao.insertSelective(buildingInfoWater);
    }
}
