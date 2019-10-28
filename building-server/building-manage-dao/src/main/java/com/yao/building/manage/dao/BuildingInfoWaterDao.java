package com.yao.building.manage.dao;

import com.yao.building.manage.domain.BuildingInfoWater;
import com.yao.building.manage.domain.BuildingInfoWaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BuildingInfoWaterDao {
    int countByExample(BuildingInfoWaterExample example);

    int deleteByExample(BuildingInfoWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildingInfoWater record);

    int insertSelective(BuildingInfoWater record);

    List<BuildingInfoWater> selectByExample(BuildingInfoWaterExample example);

    BuildingInfoWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildingInfoWater record, @Param("example") BuildingInfoWaterExample example);

    int updateByExample(@Param("record") BuildingInfoWater record, @Param("example") BuildingInfoWaterExample example);

    int updateByPrimaryKeySelective(BuildingInfoWater record);

    int updateByPrimaryKey(BuildingInfoWater record);
}