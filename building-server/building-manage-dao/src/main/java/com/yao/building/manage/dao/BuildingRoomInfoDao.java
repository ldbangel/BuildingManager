package com.yao.building.manage.dao;

import com.yao.building.manage.domain.BuildingRoomInfo;
import com.yao.building.manage.domain.BuildingRoomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BuildingRoomInfoDao {
    int countByExample(BuildingRoomInfoExample example);

    int deleteByExample(BuildingRoomInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildingRoomInfo record);

    int insertSelective(BuildingRoomInfo record);

    List<BuildingRoomInfo> selectByExample(BuildingRoomInfoExample example);

    BuildingRoomInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildingRoomInfo record, @Param("example") BuildingRoomInfoExample example);

    int updateByExample(@Param("record") BuildingRoomInfo record, @Param("example") BuildingRoomInfoExample example);

    int updateByPrimaryKeySelective(BuildingRoomInfo record);

    int updateByPrimaryKey(BuildingRoomInfo record);
}