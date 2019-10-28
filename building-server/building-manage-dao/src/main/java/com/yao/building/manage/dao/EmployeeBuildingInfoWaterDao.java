package com.yao.building.manage.dao;

import com.yao.building.manage.domain.EmployeeBuildingInfoWater;
import com.yao.building.manage.domain.EmployeeBuildingInfoWaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeBuildingInfoWaterDao {
    int countByExample(EmployeeBuildingInfoWaterExample example);

    int deleteByExample(EmployeeBuildingInfoWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeBuildingInfoWater record);

    int insertSelective(EmployeeBuildingInfoWater record);

    List<EmployeeBuildingInfoWater> selectByExample(EmployeeBuildingInfoWaterExample example);

    EmployeeBuildingInfoWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeBuildingInfoWater record, @Param("example") EmployeeBuildingInfoWaterExample example);

    int updateByExample(@Param("record") EmployeeBuildingInfoWater record, @Param("example") EmployeeBuildingInfoWaterExample example);

    int updateByPrimaryKeySelective(EmployeeBuildingInfoWater record);

    int updateByPrimaryKey(EmployeeBuildingInfoWater record);
}