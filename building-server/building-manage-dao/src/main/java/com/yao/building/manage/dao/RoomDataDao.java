package com.yao.building.manage.dao;

import java.util.List;

import com.yao.building.manage.domain.RoomData;
import com.yao.building.manage.domain.RoomDataExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomDataDao {
    int countByExample(RoomDataExample example);

    int deleteByExample(RoomDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomData record);

    int insertSelective(RoomData record);

    List<RoomData> selectByExample(RoomDataExample example);

    RoomData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomData record, @Param("example") RoomDataExample example);

    int updateByExample(@Param("record") RoomData record, @Param("example") RoomDataExample example);

    int updateByPrimaryKeySelective(RoomData record);

    int updateByPrimaryKey(RoomData record);
}