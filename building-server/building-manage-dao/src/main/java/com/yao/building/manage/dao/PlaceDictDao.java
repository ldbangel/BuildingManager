package com.yao.building.manage.dao;

import com.yao.building.manage.domain.PlaceDict;
import com.yao.building.manage.domain.PlaceDictExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
//@Mapper
public interface PlaceDictDao {
    int countByExample(PlaceDictExample example);

    int deleteByExample(PlaceDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlaceDict record);

    int insertSelective(PlaceDict record);

    List<PlaceDict> selectByExample(PlaceDictExample example);

    PlaceDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlaceDict record, @Param("example") PlaceDictExample example);

    int updateByExample(@Param("record") PlaceDict record, @Param("example") PlaceDictExample example);

    int updateByPrimaryKeySelective(PlaceDict record);

    int updateByPrimaryKey(PlaceDict record);
}