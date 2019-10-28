package com.yao.building.manage.dao;

import java.util.List;

import com.yao.building.manage.domain.RoomInfoWater;
import com.yao.building.manage.domain.RoomInfoWaterExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomInfoWaterDao {
    int countByExample(RoomInfoWaterExample example);

    int deleteByExample(RoomInfoWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomInfoWater record);

    int insertSelective(RoomInfoWater record);

    List<RoomInfoWater> selectByExample(RoomInfoWaterExample example);

    RoomInfoWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomInfoWater record, @Param("example") RoomInfoWaterExample example);

    int updateByExample(@Param("record") RoomInfoWater record, @Param("example") RoomInfoWaterExample example);

    int updateByPrimaryKeySelective(RoomInfoWater record);

    int updateByPrimaryKey(RoomInfoWater record);
}