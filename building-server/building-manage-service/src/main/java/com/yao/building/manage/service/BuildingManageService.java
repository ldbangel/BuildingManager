package com.yao.building.manage.service;

import com.yao.building.manage.request.*;
import com.yao.building.manage.response.BuildingBaseInfoResponse;
import com.yao.building.manage.response.RoomBaseInfoResponse;
import com.yao.building.manage.vo.PageBean;

public interface BuildingManageService {
    /**
     * 查询所有楼栋信息
     */
    PageBean<BuildingBaseInfoResponse> getBuildingBaseInfo(GetBuildingBaseInfoRequest request);

    /**
     * 获取某栋的详细信息
     */
    BuildingBaseInfoResponse getBuildingDetailInfo(Integer buildingId);

    /**
     * 新增、编辑楼栋信息
     */
    void addOrEditBuildingBaseInfo(AddOrEditBuildingInfoRequest request);

    /**
     * 查询所有房间信息
     * 注意：
     *  1、只能选到楼栋才能查询
     */
    PageBean<RoomBaseInfoResponse> getRoomBaseInfo(GetRoomBaseInfoRequest request);

    /**
     * 新增、编辑楼栋信息
     *  注意：
     *      1、添加时必须要选择到楼栋(前端控制)
     */
    void addOrEditRoomBaseInfo(AddOrEditRoomInfoRequest request);


    /**
     * 删除管理员
     */
    void deleteBuildingManager(DeleteBuildingManagerRequest request);

    /**
     * 新增楼栋管理员
     */
    void addBuildingManager(AddBuildingManagerRequest request);
}
