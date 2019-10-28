package com.yao.building.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.dal.BuildingInfoDal;
import com.yao.building.manage.dal.RoomInfoDal;
import com.yao.building.manage.dao.BuildingInfoDao;
import com.yao.building.manage.dao.PlaceDictDao;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.request.AddOrEditBuildingInfoRequest;
import com.yao.building.manage.request.AddOrEditRoomInfoRequest;
import com.yao.building.manage.request.GetBuildingBaseInfoRequest;
import com.yao.building.manage.request.GetRoomBaseInfoRequest;
import com.yao.building.manage.response.BaseResponse;
import com.yao.building.manage.response.BuildingBaseInfoResponse;
import com.yao.building.manage.response.RoomBaseInfoResponse;
import com.yao.building.manage.service.BuildingManageService;
import com.yao.building.manage.vo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service("buildingManageService")
public class BuildingManageServiceImpl implements BuildingManageService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private BuildingInfoDao buildingInfoDao;
    @Autowired
    private PlaceDictDao placeDictDao;
    @Autowired
    private BuildingInfoDal buildingInfoDal;
    @Autowired
    private RoomInfoDal roomInfoDal;


    @Override
    public PageBean<BuildingBaseInfoResponse> getBuildingBaseInfo(GetBuildingBaseInfoRequest request) {
        PageBean<BuildingBaseInfoResponse> responsePage = new PageBean<>();
        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);

        List<Integer> buildingIds = baseResponseList.stream().map(baseResponse -> baseResponse.getBuildingId()).distinct().collect(Collectors.toList());
        BuildingInfoExample buildingInfoExample = new BuildingInfoExample();
        BuildingInfoExample.Criteria buildingInfoCriteria = buildingInfoExample.createCriteria();
        buildingInfoCriteria.andIdIn(buildingIds);
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<BuildingInfo> buildingInfoList = buildingInfoDao.selectByExample(buildingInfoExample);
        PageBean<BuildingInfo> pageBean = new PageBean<>(buildingInfoList);
        List<BuildingBaseInfoResponse> responseList = buildingInfoList.stream()
                .map(buildingInfo -> {
                    BuildingBaseInfoResponse response = new BuildingBaseInfoResponse();
                    BeanUtils.copyProperties(buildingInfo, response);
                    response.setBuildingName(buildingInfo.getBuildingDesc());
                    response.setBuildingId(buildingInfo.getId());
                    return response;
                })
                .collect(Collectors.toList());

        BeanUtils.copyProperties(pageBean, responsePage);
        responsePage.setList(responseList);

        return responsePage;
    }

    @Override
    public BuildingBaseInfoResponse getBuildingDetailInfo(Integer buildingId) {
        BuildingInfo buildingInfo = buildingInfoDao.selectByPrimaryKey(buildingId);
        if(buildingInfo == null){
            return null;
        }
        BuildingBaseInfoResponse response = new BuildingBaseInfoResponse();
        BeanUtils.copyProperties(buildingInfo, response);
        return response;
    }

    @Override
    public void addOrEditBuildingBaseInfo(AddOrEditBuildingInfoRequest request) {
        if(request == null){
            return ;
        }
        if(request.getBuildingId() == null){
            //新增楼栋信息
            BuildingInfo buildingInfo = new BuildingInfo();
            BeanUtils.copyProperties(request, buildingInfo);
            buildingInfo.setBuildingDesc(request.getBuildingName());

            List<Integer> placeIds = new ArrayList<>();
            placeIds.add(request.getCityId());
            placeIds.add(request.getAreaId());
            placeIds.add(request.getStreetId());
            placeIds.add(request.getVillageId());
            PlaceDictExample dictExample = new PlaceDictExample();
            PlaceDictExample.Criteria placeDictCriteria = dictExample.createCriteria();
            placeDictCriteria.andStatusEqualTo(1);
            placeDictCriteria.andIdIn(placeIds);
            List<PlaceDict> placeDictList = placeDictDao.selectByExample(dictExample);
            placeDictList.stream().forEach(placeDict -> {
                if(Objects.equals(placeDict.getId(), buildingInfo.getCityId())){
                    buildingInfo.setCityName(placeDict.getPlaceName());
                }else if(Objects.equals(placeDict.getId(), buildingInfo.getAreaId())){
                    buildingInfo.setAreaName(placeDict.getPlaceName());
                }else if(Objects.equals(placeDict.getId(), buildingInfo.getVillageId())){
                    buildingInfo.setVillageName(placeDict.getPlaceName());
                }else if(Objects.equals(placeDict.getId(), buildingInfo.getStreetId())){
                    buildingInfo.setStreetName(placeDict.getPlaceName());
                }
            });

            buildingInfoDal.insert(buildingInfo);
        }else{
            if(request.getBuildingId() != 0){
                //更新楼栋信息
                BuildingInfo buildingInfo = new BuildingInfo();
                buildingInfo.setId(request.getBuildingId());
                buildingInfo.setManageFee(request.getManageFee());
                buildingInfo.setModifyTime(new Date());
                buildingInfoDal.update(buildingInfo);
            }
        }

    }

    @Override
    public PageBean<RoomBaseInfoResponse> getRoomBaseInfo(GetRoomBaseInfoRequest request) {
        PageBean<RoomBaseInfoResponse> responsePage = new PageBean<>();
        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
        List<Integer> roomIds = baseResponseList.stream().map(baseResponse -> baseResponse.getRoomId()).distinct().collect(Collectors.toList());
        PageBean<RoomInfo> pageBean = commonService.getRoomPageInfosByIds(roomIds, request.getStatus(), request.getPage(), request.getLimit());
        List<RoomInfo> roomInfoList = pageBean.getList();
        List<RoomBaseInfoResponse> responseList = roomInfoList.stream()
                .map(roomInfo -> {
                    RoomBaseInfoResponse response = new RoomBaseInfoResponse();
                    response.setRoomNo(roomInfo.getRoomNo());
                    response.setRoomId(roomInfo.getId());
                    return response;
                })
                .collect(Collectors.toList());

        commonService.coverBaseInfoToResponse(responseList, baseResponseList);
        BeanUtils.copyProperties(pageBean, responsePage);
        responsePage.setList(responseList);
        return responsePage;
    }

    @Override
    public void addOrEditRoomBaseInfo(AddOrEditRoomInfoRequest request) {
        if(request == null){
            return ;
        }

        if(request.getRoomId() == null){
            // 新增房间信息
            RoomInfo roomInfo = new RoomInfo();
            BeanUtils.copyProperties(request, roomInfo);
            roomInfo.setRoomStatus(0);
            roomInfo.setCreateTime(new Date());
            roomInfo.setModifyTime(new Date());
            roomInfoDal.insert(roomInfo);
        }else{
            if(request.getRoomId() != 0){
                RoomInfo roomInfo = new RoomInfo();
                roomInfo.setId(request.getRoomId());
                roomInfo.setRoomNo(request.getRoomNo());
                roomInfo.setWaterNum(request.getWaterNum());
                roomInfo.setEnergyNum(request.getEnergyNum());
                roomInfoDal.update(roomInfo);
            }
        }
    }
}