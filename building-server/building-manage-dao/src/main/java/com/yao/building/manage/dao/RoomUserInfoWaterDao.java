package com.yao.building.manage.dao;

import com.yao.building.manage.domain.RoomUserInfoWater;
import com.yao.building.manage.domain.RoomUserInfoWaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomUserInfoWaterDao {
    int countByExample(RoomUserInfoWaterExample example);

    int deleteByExample(RoomUserInfoWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomUserInfoWater record);

    int insertSelective(RoomUserInfoWater record);

    List<RoomUserInfoWater> selectByExample(RoomUserInfoWaterExample example);

    RoomUserInfoWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomUserInfoWater record, @Param("example") RoomUserInfoWaterExample example);

    int updateByExample(@Param("record") RoomUserInfoWater record, @Param("example") RoomUserInfoWaterExample example);

    int updateByPrimaryKeySelective(RoomUserInfoWater record);

    int updateByPrimaryKey(RoomUserInfoWater record);
}