package com.yao.building.manage.dao;

import com.yao.building.manage.domain.EmployeeBuildingInfo;
import com.yao.building.manage.domain.EmployeeBuildingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeBuildingInfoDao {
    int countByExample(EmployeeBuildingInfoExample example);

    int deleteByExample(EmployeeBuildingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeBuildingInfo record);

    int insertSelective(EmployeeBuildingInfo record);

    List<EmployeeBuildingInfo> selectByExample(EmployeeBuildingInfoExample example);

    EmployeeBuildingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeBuildingInfo record, @Param("example") EmployeeBuildingInfoExample example);

    int updateByExample(@Param("record") EmployeeBuildingInfo record, @Param("example") EmployeeBuildingInfoExample example);

    int updateByPrimaryKeySelective(EmployeeBuildingInfo record);

    int updateByPrimaryKey(EmployeeBuildingInfo record);
}