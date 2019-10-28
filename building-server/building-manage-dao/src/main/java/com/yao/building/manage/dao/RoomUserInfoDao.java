package com.yao.building.manage.dao;

import com.yao.building.manage.domain.RoomUserInfo;
import com.yao.building.manage.domain.RoomUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoomUserInfoDao {
    int countByExample(RoomUserInfoExample example);

    int deleteByExample(RoomUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomUserInfo record);

    int insertSelective(RoomUserInfo record);

    List<RoomUserInfo> selectByExample(RoomUserInfoExample example);

    RoomUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomUserInfo record, @Param("example") RoomUserInfoExample example);

    int updateByExample(@Param("record") RoomUserInfo record, @Param("example") RoomUserInfoExample example);

    int updateByPrimaryKeySelective(RoomUserInfo record);

    int updateByPrimaryKey(RoomUserInfo record);
}