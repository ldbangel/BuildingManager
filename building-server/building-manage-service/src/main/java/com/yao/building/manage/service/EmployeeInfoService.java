package com.yao.building.manage.service;

import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.request.GetBuildingAndEmployeeInfoRequest;
import com.yao.building.manage.request.ModifyEmployeeInfoRequest;
import com.yao.building.manage.request.PageRequest.BaseRequest;
import com.yao.building.manage.request.QueryEmployeeInfSimpleRequest;
import com.yao.building.manage.response.BuildingAndEmployeeInfoResponse;
import com.yao.building.manage.vo.PageBean;

public interface EmployeeInfoService {
    /**
     * 获取员工信息
     */
    Employee queryEmployeeInfoSimple(QueryEmployeeInfSimpleRequest request);

    /**
     * 修改员工信息
     */
    int modifyEmployeeInfo(ModifyEmployeeInfoRequest request);

    /**
     * 批量获取楼栋--管理员信息
     */
    PageBean<BuildingAndEmployeeInfoResponse> getBuildingAndEmployeeInfos(GetBuildingAndEmployeeInfoRequest request);

    /**
     * 获取单栋楼房--管理员信息 详情
     * 注意:
     *    1、一定要有buildingId
     */
    BuildingAndEmployeeInfoResponse getBuildingEmployeeInfoSimple(BaseRequest request);

}
