package com.yao.building.manage.dal;

import com.yao.building.manage.dao.EmployeeBuildingInfoDao;
import com.yao.building.manage.dao.EmployeeBuildingInfoWaterDao;
import com.yao.building.manage.domain.BuildingInfo;
import com.yao.building.manage.domain.BuildingInfoWater;
import com.yao.building.manage.domain.EmployeeBuildingInfo;
import com.yao.building.manage.domain.EmployeeBuildingInfoWater;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BuildingManagerDal {
    @Autowired
    private EmployeeBuildingInfoDao employeeBuildingInfoDao;
    @Autowired
    private EmployeeBuildingInfoWaterDao employeeBuildingInfoWaterDao;

    public void insert(EmployeeBuildingInfo employeeBuildingInfo){
        employeeBuildingInfoDao.insertSelective(employeeBuildingInfo);
        EmployeeBuildingInfoWater employeeBuildingInfoWater = new EmployeeBuildingInfoWater();
        BeanUtils.copyProperties(employeeBuildingInfo, employeeBuildingInfoWater, "id");
        employeeBuildingInfoWater.setIndex(employeeBuildingInfo.getId());
        employeeBuildingInfoWater.setModifyTime(new Date());
        employeeBuildingInfoWaterDao.insertSelective(employeeBuildingInfoWater);
    }

    public void update(EmployeeBuildingInfo employeeBuildingInfo){
        employeeBuildingInfoDao.updateByPrimaryKeySelective(employeeBuildingInfo);
        EmployeeBuildingInfo newEmployeeBuildingInfo = employeeBuildingInfoDao.selectByPrimaryKey(employeeBuildingInfo.getId());
        EmployeeBuildingInfoWater employeeBuildingInfoWater = new EmployeeBuildingInfoWater();
        BeanUtils.copyProperties(newEmployeeBuildingInfo, employeeBuildingInfoWater, "id");
        employeeBuildingInfoWater.setIndex(newEmployeeBuildingInfo.getId());
        employeeBuildingInfoWater.setModifyTime(new Date());
        employeeBuildingInfoWaterDao.insertSelective(employeeBuildingInfoWater);
    }
}
