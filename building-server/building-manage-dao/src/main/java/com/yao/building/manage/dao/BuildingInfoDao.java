package com.yao.building.manage.dao;

import com.yao.building.manage.domain.BuildingInfo;
import com.yao.building.manage.domain.BuildingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BuildingInfoDao {
    int countByExample(BuildingInfoExample example);

    int deleteByExample(BuildingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildingInfo record);

    int insertSelective(BuildingInfo record);

    List<BuildingInfo> selectByExample(BuildingInfoExample example);

    BuildingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildingInfo record, @Param("example") BuildingInfoExample example);

    int updateByExample(@Param("record") BuildingInfo record, @Param("example") BuildingInfoExample example);

    int updateByPrimaryKeySelective(BuildingInfo record);

    int updateByPrimaryKey(BuildingInfo record);
}