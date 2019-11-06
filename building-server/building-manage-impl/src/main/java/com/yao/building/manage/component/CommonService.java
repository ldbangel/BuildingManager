package com.yao.building.manage.component;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.dao.BuildingInfoDao;
import com.yao.building.manage.dao.BuildingRoomInfoDao;
import com.yao.building.manage.dao.RoomInfoDao;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.request.PageRequest.BaseRequest;
import com.yao.building.manage.response.BaseResponse;
import com.yao.building.manage.vo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CommonService {
    @Autowired
    private BuildingInfoDao buildingInfoDao;
    @Autowired
    private BuildingRoomInfoDao buildingRoomInfoDao;
    @Autowired
    private RoomInfoDao roomInfoDao;

    public <T1 extends BaseResponse, T2 extends BaseRequest> List<T1> getAllRoomIds(T2 request){
        List<T1> responseList = new ArrayList<T1>();
        if(request == null){
            log.info("request can not be null! please check again");
            throw new RuntimeException("参数错误");
        }
        if(request.getRoomId() != null && request.getRoomId() != 0){
            BuildingInfo buildingInfo = getBuildingInfoByRoomId(request.getRoomId());
            T1 response = (T1) new BaseResponse();
            coverBuildingInfoToResponse(response, buildingInfo);
            response.setRoomId(request.getRoomId());
            responseList.add(response);
        }else{
            BuildingInfoExample buildingInfoExample = new BuildingInfoExample();
            BuildingInfoExample.Criteria buildingInfoCriteria = buildingInfoExample.createCriteria();
            if(request.getBuildingId() != null && request.getBuildingId() != 0){
                buildingInfoCriteria.andIdEqualTo(request.getBuildingId());
            }else if(request.getVillageId() != null && request.getVillageId() != 0){
                buildingInfoCriteria.andVillageIdEqualTo(request.getVillageId());
            }else if(request.getStreetId() != null && request.getStreetId() != 0){
                buildingInfoCriteria.andStreetIdEqualTo(request.getStreetId());
            }else if(request.getAreaId() != null && request.getAreaId() != 0){
                buildingInfoCriteria.andAreaIdEqualTo(request.getAreaId());
            }else if(request.getCityId() != null && request.getCityId() != 0){
                buildingInfoCriteria.andCityIdEqualTo(request.getCityId());
            }
            List<BuildingInfo> buildingInfoList= buildingInfoDao.selectByExample(buildingInfoExample);

            //获取所有的楼栋ID
            List<Integer> buildingIdList = buildingInfoList.stream()
                    .map(buildingInfo -> buildingInfo.getId())
                    .collect(Collectors.toList());

            // 楼栋和房间关联信息查询
            BuildingRoomInfoExample example = new BuildingRoomInfoExample();
            BuildingRoomInfoExample.Criteria criteria = example.createCriteria();
            criteria.andBuildingIdIn(buildingIdList);
            List<BuildingRoomInfo> buildingRoomInfos = buildingRoomInfoDao.selectByExample(example);

            if(buildingRoomInfos == null || buildingRoomInfos.size() < 1){
                throw new RuntimeException("楼栋房间信息为空！");
            }

            responseList = buildingRoomInfos.stream()
                    .map(buildingRoomInfo -> {
                        T1 response = (T1) new BaseResponse();
                        response.setBuildingId(buildingRoomInfo.getBuildingId());
                        response.setRoomId(buildingRoomInfo.getRoomId());
                        return response;
                    }).collect(Collectors.toList());

            responseList = responseList.stream()
                    .map(response -> buildingInfoList.stream()
                            .filter(buildingInfo -> Objects.equals(buildingInfo.getId(), response.getBuildingId()))
                            .findFirst()
                            .map(buildingInfo -> {
                                coverBuildingInfoToResponse(response, buildingInfo);
                                return response;
                            }).orElse(response))
                    .collect(Collectors.toList());
        }
        return responseList;
    }

    //根据房间ID查询楼栋信息
    public BuildingInfo getBuildingInfoByRoomId(Integer roomId){
        BuildingRoomInfoExample example = new BuildingRoomInfoExample();
        BuildingRoomInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdIn(Arrays.asList(roomId));
        List<BuildingRoomInfo> buildingRoomInfos = buildingRoomInfoDao.selectByExample(example);
        if(CollectionUtils.isEmpty(buildingRoomInfos)){
            log.info("buildingRoomInfos is null, roomId is invalid, roomId = {}", roomId);
            return null;
        }
        BuildingRoomInfo buildingRoomInfo = buildingRoomInfos.get(0);
        BuildingInfo buildingInfo= buildingInfoDao.selectByPrimaryKey(buildingRoomInfo.getBuildingId());
        return buildingInfo;
    }

    /**
     * 获取房间信息，通过房间ID
     * 重点：不分页
     */
    public List<RoomInfo> getRoomInfosByIds(List<Integer> roomIds, Integer status) {
        RoomInfoExample roomInfoExample = new RoomInfoExample();
        RoomInfoExample.Criteria roomInfoCriteria = roomInfoExample.createCriteria();
        roomInfoCriteria.andIdIn(roomIds);
        if(status != null){
            roomInfoCriteria.andRoomStatusEqualTo(status);
        }
        return roomInfoDao.selectByExample(roomInfoExample);
    }

    /**
     * 获取房间信息，通过房间ID
     * 重点：分页
     */
    public PageBean<RoomInfo> getRoomPageInfosByIds(List<Integer> roomIds, Integer status, Integer page, Integer limit) {
        RoomInfoExample roomInfoExample = new RoomInfoExample();
        RoomInfoExample.Criteria roomInfoCriteria = roomInfoExample.createCriteria();
        roomInfoCriteria.andIdIn(roomIds);
        if(status != null){
            roomInfoCriteria.andRoomStatusEqualTo(status);
        }
        PageHelper.startPage(page, limit);
        List<RoomInfo> roomInfoList = roomInfoDao.selectByExample(roomInfoExample);
        PageBean<RoomInfo> pageBean = new PageBean<>(roomInfoList);

        return pageBean;
    }

    /**
     * 把baseResponse里的基本信息赋值给T1
     */
    public <T1 extends BaseResponse> void coverBaseInfoToResponse(List<T1> responseList, List<BaseResponse> baseResponseList){
        responseList.stream()
                .map(response -> baseResponseList.stream()
                        .filter(baseResponse -> Objects.equals(baseResponse.getRoomId(), response.getRoomId()))
                        .findFirst()
                        .map(baseResponse -> {
                            response.setAreaName(baseResponse.getAreaName());
                            response.setCityName(baseResponse.getCityName());
                            response.setBuildingName(baseResponse.getBuildingName());
                            response.setStreetName(baseResponse.getStreetName());
                            response.setVillageName(baseResponse.getVillageName());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());
    }

    /**
     * 将单栋楼栋信息赋值给T1
     */
    public <T1 extends BaseResponse> void coverBuildingInfoToResponse(T1 response, BuildingInfo buildingInfo){
        response.setAreaName(buildingInfo.getAreaName());
        response.setCityName(buildingInfo.getCityName());
        response.setBuildingName(buildingInfo.getBuildingDesc());
        response.setStreetName(buildingInfo.getStreetName());
        response.setVillageName(buildingInfo.getVillageName());
        response.setManageFee(buildingInfo.getManageFee());
        response.setCleanFee(buildingInfo.getCleanFee());
        response.setInternetFee(buildingInfo.getInternetFee());
    }

    /**
     * 匹配房间信息到response
     */
    public <T1 extends BaseResponse> void  matchRoomInfoToResponse(List<T1> responseList, List<RoomInfo> roomInfoList){
        responseList.stream()
                .map(response -> roomInfoList.stream()
                        .filter(roomInfo -> Objects.equals(roomInfo.getId(), response.getRoomId()))
                        .findFirst()
                        .map(roomInfo -> {
                            response.setRoomNo(roomInfo.getRoomNo());
                            response.setRentStatus(roomInfo.getRoomStatus() == 1 ? "在租" : "未租");
                            response.setRoomType(roomInfo.getRoomType());
                            response.setRoomTypeDesc(roomInfo.getRoomTypeDesc());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());
    }

    /**
     * 匹配房间租客信息到response
     */
    /*public <T1 extends BaseResponse> void  matchRoomUserInfoToResponse(List<T1> responseList, List<RoomUserInfo> roomUserInfoList){
        responseList = responseList.stream()
                .map(response -> roomUserInfoList.stream()
                        .filter(roomUserInfo -> Objects.equals(roomUserInfo.getUserId(), response.getUserId()))
                        .findFirst()
                        .map(roomUserInfo -> {
                            response.setRoomId(roomUserInfo.getRoomId());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());
    }*/

}
