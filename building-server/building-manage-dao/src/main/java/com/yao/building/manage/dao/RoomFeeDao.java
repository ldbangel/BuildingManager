package com.yao.building.manage.dao;

import com.yao.building.manage.domain.RoomFee;
import com.yao.building.manage.domain.RoomFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomFeeDao {
    int countByExample(RoomFeeExample example);

    int deleteByExample(RoomFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomFee record);

    int insertSelective(RoomFee record);

    List<RoomFee> selectByExample(RoomFeeExample example);

    RoomFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomFee record, @Param("example") RoomFeeExample example);

    int updateByExample(@Param("record") RoomFee record, @Param("example") RoomFeeExample example);

    int updateByPrimaryKeySelective(RoomFee record);

    int updateByPrimaryKey(RoomFee record);
}