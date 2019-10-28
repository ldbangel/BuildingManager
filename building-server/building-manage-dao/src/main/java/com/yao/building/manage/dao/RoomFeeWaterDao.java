package com.yao.building.manage.dao;

import com.yao.building.manage.domain.RoomFeeWater;
import com.yao.building.manage.domain.RoomFeeWaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomFeeWaterDao {
    int countByExample(RoomFeeWaterExample example);

    int deleteByExample(RoomFeeWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomFeeWater record);

    int insertSelective(RoomFeeWater record);

    List<RoomFeeWater> selectByExample(RoomFeeWaterExample example);

    RoomFeeWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomFeeWater record, @Param("example") RoomFeeWaterExample example);

    int updateByExample(@Param("record") RoomFeeWater record, @Param("example") RoomFeeWaterExample example);

    int updateByPrimaryKeySelective(RoomFeeWater record);

    int updateByPrimaryKey(RoomFeeWater record);
}