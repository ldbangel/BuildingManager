package com.yao.building.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.common.utils.DateUtil;
import com.yao.building.manage.component.CommonService;
import com.yao.building.manage.constant.UnitPriceConstant;
import com.yao.building.manage.dal.RoomInfoDal;
import com.yao.building.manage.dal.RoomUserInfoDal;
import com.yao.building.manage.dao.*;
import com.yao.building.manage.domain.*;
import com.yao.building.manage.exception.BuildingErrorCode;
import com.yao.building.manage.exception.BuildingException;
import com.yao.building.manage.request.*;
import com.yao.building.manage.request.PageRequest.UserBaseInfo;
import com.yao.building.manage.response.*;
import com.yao.building.manage.service.RoomInfoService;
import com.yao.building.manage.vo.PageBean;
import com.yao.building.manage.vo.RoomUserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service("roomInfoService")
public class RoomInfoServiceImpl implements RoomInfoService {
    @Autowired
    private RoomUserInfoDao roomUserInfoDao;
    @Autowired
    private BuildingRoomInfoDao buildingRoomInfoDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RoomInfoDao roomInfoDao;
    @Autowired
    private BuildingInfoDao buildingInfoDao;
    @Autowired
    private RoomDataDao roomDataDao;
    @Autowired
    private RoomFeeDao roomFeeDao;

    @Autowired
    private RoomInfoDal roomInfoDal;
    @Autowired
    private RoomUserInfoDal roomUserInfoDal;

    @Autowired
    private CommonService commonService;

    public List<RoomUserInfoResponse> getRoomUserInfo(GetRoomUserInfoRequest request) {
        // 只查询在租的信息
        request.setStatus(1);
        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
        List<Integer> roomIdList = baseResponseList.stream()
                .map(baseResponse -> baseResponse.getRoomId())
                .collect(Collectors.toList());

        List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(roomIdList, request.getStatus());

        if(CollectionUtils.isEmpty(roomInfoList)){
            return (List<RoomUserInfoResponse>) CollectionUtils.EMPTY_COLLECTION;
        }
        // 房间和租客关系信息查询
        List<RoomUserInfo> roomUserInfoList = getRoomUserInfosByRoomIds(roomIdList);


        List<Integer> userIds = roomUserInfoList.stream()
                .map(roomUserInfo -> roomUserInfo.getUserId())
                .collect(Collectors.toList());
        List<UserInfo> userInfos = getUserInfosByIds(userIds, 1);

        List<RoomUserInfoResponse> responseList = userInfos.stream()
                .map(userInfo -> {
                    RoomUserInfoResponse response = new RoomUserInfoResponse();
                    BeanUtils.copyProperties(userInfo, response);
                    response.setUserId(userInfo.getId());
                    response.setRentBeginTime(DateUtil.format(userInfo.getRentBeginTime(), DateUtil.yyyy_MM_dd));
                    return response;
                }).collect(Collectors.toList());

        responseList.stream()
                .map(response -> roomUserInfoList.stream()
                        .filter(roomUserInfo -> Objects.equals(response.getUserId(), roomUserInfo.getUserId()))
                        .findFirst()
                        .map(roomUserInfo -> {
                            response.setRoomId(roomUserInfo.getRoomId());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());

        commonService.matchRoomInfoToResponse(responseList, roomInfoList);

        commonService.coverBaseInfoToResponse(responseList, baseResponseList);
        return responseList;
    }

    @Override
    public UserInfo getUserDetailInfo(GetUserDetailInfoRequest request) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andIdEqualTo(request.getUserId());
        criteria.andStatusEqualTo(1);
        List<UserInfo> userInfos  = userInfoDao.selectByExample(userInfoExample);
        if(CollectionUtils.isEmpty(userInfos)){
            return null;
        }
        UserInfo userInfo =  userInfos.get(0);
        return userInfo;
    }

    @Override
    public RoomInfoResponse getRoomBaseInfo(Integer roomId) {
        RoomInfoResponse response = new RoomInfoResponse();
        RoomInfo roomInfo = roomInfoDao.selectByPrimaryKey(roomId);
        BeanUtils.copyProperties(roomInfo, response);
        response.setRoomId(roomInfo.getId());
        return response;
    }

    @Override
    public List<RoomRentBaseInfoResponse> getRoomRentBaseInfoOfMonth(GetRoomRentBaseInfoRequest request) {
        if(request == null || request.getRoomId() == null || request.getRoomId() == 0){
            log.info("GetRoomRentBaseInfoRequest invalid !");
            throw new BuildingException(BuildingErrorCode.INVALID_PARAMS);
        }
        //通过roomId获取buildingInfo信息
        BuildingInfo buildingInfo= commonService.getBuildingInfoByRoomId(request.getRoomId());

        RoomInfo roomInfo = roomInfoDao.selectByPrimaryKey(request.getRoomId());

        RoomDataExample roomDataExample = new RoomDataExample();
        RoomDataExample.Criteria roomDataCriteria = roomDataExample.createCriteria();
        roomDataCriteria.andRoomIdEqualTo(request.getRoomId());
        roomDataCriteria.andRentStatusNotEqualTo(1);
        List<RoomData> roomDatas = roomDataDao.selectByExample(roomDataExample);

        List<RoomRentBaseInfoResponse> responseList =
                roomDatas.stream()
                        .map(roomData -> {
                            RoomRentBaseInfoResponse response =  new RoomRentBaseInfoResponse();
                            BeanUtils.copyProperties(roomData, response);
                            response.setReadTime(DateUtil.format(roomData.getReadTime(), DateUtil.yyyy_MM_dd));
                            response.setReportTime(DateUtil.format(roomData.getCreateTime(), DateUtil.yyyy_MM_dd));
                            return response;
                        }).collect(Collectors.toList());

        responseList = responseList.stream()
                .map(response -> {
                    response.setRoomNo(roomInfo.getRoomNo());
                    response.setRoomId(roomInfo.getId());
                    response.setRoomType(roomInfo.getRoomType());
                    response.setRoomTypeDesc(roomInfo.getRoomTypeDesc());
                    return response;
                }).collect(Collectors.toList());

        responseList = responseList.stream()
                .map(response -> {
                    response.setVillageName(buildingInfo.getVillageName());
                    response.setBuildingName(buildingInfo.getBuildingDesc());
                    response.setManageFee(buildingInfo.getManageFee());
                    return response;
                }).collect(Collectors.toList());

        return responseList;
    }

    @Override
    public int addRoomRentBaseInfo(AddRoomRentBaseInfoRequest request) {
        if(request == null || request.getRoomId() == null){
            throw new BuildingException(BuildingErrorCode.INVALID_PARAMS);
        }
        int result = addRoomRentDataInfo(request, 2);
        return result;
    }

    @Override
    public void cancelRoomRent(CancelRoomRentRequest request) {
        if(request == null || request.getRoomId() == null){
            throw new BuildingException(BuildingErrorCode.INVALID_PARAMS);
        }
        AddRoomRentBaseInfoRequest addRoomRentBaseInfoRequest = new AddRoomRentBaseInfoRequest();
        addRoomRentBaseInfoRequest.setReadTime(request.getRentEndTime());
        addRoomRentBaseInfoRequest.setWaterNum(request.getWaterNum());
        addRoomRentBaseInfoRequest.setEnergyNum(request.getEnergyNum());
        addRoomRentBaseInfoRequest.setRoomId(request.getRoomId());
        addRoomRentBaseInfoRequest.setOperator(request.getOperator());

        // 上传退租时房间数据
        int addResult = addRoomRentDataInfo(addRoomRentBaseInfoRequest, 0);

        RoomUserInfoExample roomUserInfoExample = new RoomUserInfoExample();
        RoomUserInfoExample.Criteria roomUserInfoCriteria = roomUserInfoExample.createCriteria();
        roomUserInfoCriteria.andRoomIdEqualTo(request.getRoomId());
        roomUserInfoCriteria.andBindStatusEqualTo(1);
        List<RoomUserInfo> roomUserInfos = roomUserInfoDao.selectByExample(roomUserInfoExample);

        // 更新房间用户关系、租客信息
        roomUserInfos.stream()
                .forEach(roomUserInfo -> {
                    roomUserInfo.setBindStatus(0);
                    roomUserInfoDao.updateByPrimaryKeySelective(roomUserInfo);

                    UserInfo userInfo = userInfoDao.selectByPrimaryKey(roomUserInfo.getUserId());
                    userInfo.setStatus(0);
                    try {
                        userInfo.setRentEndTime(DateUtil.parse(request.getRentEndTime(), DateUtil.yyyy_MM_dd));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    userInfo.setModifyTime(new Date());
                    userInfoDao.updateByPrimaryKeySelective(userInfo);
                });
    }

    @Override
    public PageBean<AbleCancelRoomResponse> getAllAbleToCancelRoomInfo(GetAllAbleToCancelRoomRequest request) {
        PageBean<AbleCancelRoomResponse> pageResponse = new PageBean<>();
        request.setStatus(1);
        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
        List<Integer> roomIds = baseResponseList.stream()
                .map(baseResponse -> baseResponse.getRoomId())
                .collect(Collectors.toList());

        PageBean<RoomInfo> pageBean = commonService.getRoomPageInfosByIds(roomIds, request.getStatus(), request.getPage(), request.getLimit());
        List<RoomInfo> roomInfoList = pageBean.getList();

        if(CollectionUtils.isEmpty(roomInfoList)){
            return pageResponse;
        }
        List<Integer> validRoomIds = roomInfoList.stream()
                .map(RoomInfo -> RoomInfo.getId())
                .collect(Collectors.toList());

        List<RoomUserInfo> roomUserInfoList = getRoomUserInfosByRoomIds(validRoomIds);

        List<AbleCancelRoomResponse> responseList = roomInfoList.stream()
                .map(roomInfo -> {
                    AbleCancelRoomResponse response = new AbleCancelRoomResponse();
                    response.setRoomId(roomInfo.getId());
                    response.setRoomNo(roomInfo.getRoomNo());
                    response.setRoomType(roomInfo.getRoomType());
                    response.setRoomTypeDesc(roomInfo.getRoomTypeDesc());
                    response.setRentStatus("在租");
                    return response;
                })
                .collect(Collectors.toList());

        responseList = responseList.stream()
                .map(response -> roomUserInfoList.stream()
                        .filter(roomUserInfo -> Objects.equals(roomUserInfo.getRoomId(), response.getRoomId()))
                        .findFirst()
                        .map(roomUserInfo -> {
                            response.setUserId(roomUserInfo.getUserId());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());

        List<Integer> userIds = responseList.stream()
                .map(response -> response.getUserId())
                .collect(Collectors.toList());

        List<UserInfo> userInfos = getUserInfosByIds(userIds, 1);

        responseList = responseList.stream()
                .map(response -> userInfos.stream()
                        .filter(userInfo -> Objects.equals(userInfo.getId(), response.getUserId()))
                        .findFirst()
                        .map(userInfo -> {
                            response.setUsername(userInfo.getUsername());
                            response.setUserMobile(userInfo.getUserMobile());
                            return response;
                        }).orElse(response))
                .collect(Collectors.toList());

        commonService.coverBaseInfoToResponse(responseList, baseResponseList);
        BeanUtils.copyProperties(pageBean, pageResponse);
        pageResponse.setList(responseList);
        return pageResponse;
    }

    @Override
    public PageBean<AbleToRentRoomResponse> getAllAbleToRentRoomInfo(GetAllAbleToRentRoomRequest request) {
        PageBean<AbleToRentRoomResponse> pageResponse = new PageBean<>();
        // 楼栋信息查询
        BuildingInfo buildingInfo = buildingInfoDao.selectByPrimaryKey(request.getBuildingId());
        // 根据楼栋ID查询所有房间信息
        PageBean<RoomInfo> pageBean = getRoomInfosByBuildingId(request.getBuildingId(), 0, request.getPage(), request.getLimit());
        List<RoomInfo> roomInfoList = pageBean.getList();

        List<AbleToRentRoomResponse> responseList = roomInfoList.stream()
                .map(roomInfo -> {
                    AbleToRentRoomResponse response = new AbleToRentRoomResponse();
                    response.setVillageName(buildingInfo.getVillageName());
                    response.setBuildingName(buildingInfo.getBuildingDesc());
                    response.setManageFee(buildingInfo.getManageFee());
                    response.setCleanFee(buildingInfo.getCleanFee());
                    response.setInternetFee(buildingInfo.getInternetFee());
                    response.setRoomNo(roomInfo.getRoomNo());
                    response.setRoomId(roomInfo.getId());
                    response.setRoomType(roomInfo.getRoomType());
                    response.setRoomTypeDesc(roomInfo.getRoomTypeDesc());
                    response.setRentStatus("未租");
                    return response;
                })
                .collect(Collectors.toList());

        BeanUtils.copyProperties(pageBean, pageResponse);
        pageResponse.setList(responseList);
        return pageResponse;
    }

    @Override
    public int bindRoomWithUserInfo(BindRoomWithUserRequest request) {
        //1、新增租客信息
        List<UserBaseInfo> userBaseInfoList = request.getUserBaseInfos();
        List<UserInfo> userInfoList = userBaseInfoList.stream()
                .map(userBaseInfo -> {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUserIdCard(userBaseInfo.getUserIdCard());
                    userInfo.setUserMobile(userBaseInfo.getUserMobile());
                    userInfo.setUsername(userBaseInfo.getUsername());
                    userInfo.setStatus(1);
                    try {
                        userInfo.setRentBeginTime(DateUtil.parse(request.getRentBeginTime(), DateUtil.yyyy_MM_dd_HH_mm_ss));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date now   = new Date();
                    userInfo.setCreateTime(now);
                    userInfo.setModifyTime(now);
                    userInfoDao.insertSelective(userInfo);
                    return userInfo;
                }).collect(Collectors.toList());

        //2、建立房间关系
        userInfoList.stream()
                .forEach(userInfo -> {
                    RoomUserInfo roomUserInfo = new RoomUserInfo();
                    roomUserInfo.setRoomId(request.getRoomId());
                    roomUserInfo.setUserId(userInfo.getId());
                    roomUserInfo.setBindStatus(1);
                    Date now =  new Date();
                    roomUserInfo.setCreateTime(now);
                    roomUserInfo.setModifyTime(now);
                    roomUserInfoDal.insert(roomUserInfo);
                });

        //3、新增房间数据、修改房间状态信息
        AddRoomRentBaseInfoRequest addRentBaseInfoRequest = new AddRoomRentBaseInfoRequest();
        BeanUtils.copyProperties(request, addRentBaseInfoRequest);
        int addResult = addRoomRentDataInfo(addRentBaseInfoRequest, 1);

        return addResult;
    }

    @Override
    public List<RoomStatusInfoResponse> getRoomStatusInfos(GetRoomStatusInfoRequest request) {
        List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
        List<Integer> roomIdList = baseResponseList.stream()
                .map(baseResponse -> baseResponse.getRoomId())
                .collect(Collectors.toList());

        PageBean<RoomInfo> roomInfoPageBean = commonService.getRoomPageInfosByIds(roomIdList, request.getStatus(), request.getPage(), request.getLimit());

        List<RoomInfo> roomInfoList = roomInfoPageBean.getList();

        List<RoomStatusInfoResponse> responseList = roomInfoList.stream()
                .map(roomInfo -> {
                    RoomStatusInfoResponse response = new RoomStatusInfoResponse();
                    response.setRoomId(roomInfo.getId());
                    response.setRoomNo(roomInfo.getRoomNo());
                    response.setRentStatus(roomInfo.getRoomStatus() == 0 ? "未租" : "已租");
                    response.setRoomType(roomInfo.getRoomType());
                    response.setRoomTypeDesc(roomInfo.getRoomTypeDesc());
                    return response;
                })
                .collect(Collectors.toList());
        commonService.coverBaseInfoToResponse(responseList, baseResponseList);
        return responseList;
    }

    @Override
    public PageBean<RoomAndDataInfoResponse> getRoomAndDataInfo(GetRoomAndDataInfoRequest request) {
        PageBean<RoomAndDataInfoResponse> pageResponse = new PageBean<>();
        if(request.getRoomId() != null && request.getRoomId() != 0){
            BuildingInfo buildingInfo = commonService.getBuildingInfoByRoomId(request.getRoomId());
            RoomDataExample roomDataExample = new RoomDataExample();
            RoomDataExample.Criteria roomDataCriteria = roomDataExample.createCriteria();
            roomDataCriteria.andRoomIdEqualTo(request.getRoomId());
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<RoomData> roomDataList =  roomDataDao.selectByExample(roomDataExample);
            PageBean<RoomData> pageBean = new PageBean<>(roomDataList);

            if(roomDataList == null || roomDataList.size() < 1){
                return pageResponse;
            }

            List<Integer> roomIds = roomDataList.stream()
                    .map(roomData -> roomData.getRoomId())
                    .distinct()
                    .collect(Collectors.toList());

            List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(roomIds, null);


            List<RoomAndDataInfoResponse> responseList = roomDataList.stream()
                    .map(roomData -> {
                        RoomAndDataInfoResponse response = new RoomAndDataInfoResponse();
                        response.setRoomId(roomData.getRoomId());
                        response.setEnergyNum(roomData.getEnergyNum());
                        response.setWaterNum(roomData.getWaterNum());
                        response.setOpenInternet(roomData.getOpenInternet());
                        response.setRent(roomData.getRent());
                        response.setReadTime(DateUtil.format(roomData.getReadTime(), DateUtil.yyyy_MM_dd));
                        response.setOperator(roomData.getOperator());
                        response.setManageFee(buildingInfo.getManageFee());
                        response.setAreaName(buildingInfo.getAreaName());
                        response.setBuildingName(buildingInfo.getBuildingDesc());
                        response.setCityName(buildingInfo.getCityName());
                        response.setStreetName(buildingInfo.getStreetName());
                        response.setVillageName(buildingInfo.getVillageName());
                        return response;
                    })
                    .collect(Collectors.toList());

            commonService.matchRoomInfoToResponse(responseList, roomInfoList);

            BeanUtils.copyProperties(pageBean, pageResponse);
            pageResponse.setList(responseList);
            return pageResponse;
        }else{
            return null;
        }
    }

    @Override
    public PageBean<UserBaseAndAddressInfoResponse> getUserBaseAndAddressInfo(GetHistoryUserInfoRequest request) {
        PageBean<UserBaseAndAddressInfoResponse> responsePage = new PageBean<>();
        if(StringUtils.isNotEmpty(request.getUserIdCard())
                || StringUtils.isNotEmpty(request.getUserMobile())
                || StringUtils.isNotEmpty(request.getUsername())){
            UserInfoExample userInfoExample = new UserInfoExample();
            UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
            if(StringUtils.isNotEmpty(request.getUserIdCard())){
                userInfoCriteria.andUserIdCardEqualTo(request.getUserIdCard());
            }
            if(StringUtils.isNotEmpty(request.getUserMobile())){
                userInfoCriteria.andUserMobileEqualTo(request.getUserMobile());
            }
            if(StringUtils.isNotEmpty(request.getUsername())){
                userInfoCriteria.andUsernameEqualTo(request.getUsername());
            }
            if(request.getStatus() != null){
                userInfoCriteria.andStatusEqualTo(request.getStatus());
            }
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<UserInfo> userInfos = userInfoDao.selectByExample(userInfoExample);
            PageBean<UserInfo> pageBean = new PageBean<>(userInfos);

            List<UserBaseAndAddressInfoResponse> responseList = userInfos.stream()
                    .map(userInfo -> {
                        UserBaseAndAddressInfoResponse response = new UserBaseAndAddressInfoResponse();
                        response.setUserId(userInfo.getId());
                        response.setUserIdCard(userInfo.getUserIdCard());
                        response.setUsername(userInfo.getUsername());
                        response.setUserMobile(userInfo.getUserMobile());
                        response.setStatus(userInfo.getStatus() == 0 ? "退租" : "在租");
                        response.setRentBeginTime(DateUtil.format(userInfo.getRentBeginTime(), DateUtil.yyyy_MM_dd));
                        response.setRentEndTime(DateUtil.format(userInfo.getRentEndTime(), DateUtil.yyyy_MM_dd));
                        return response;
                    }).collect(Collectors.toList());

            List<Integer> userIdList = userInfos.stream()
                    .map(userInfo -> userInfo.getId())
                    .distinct().collect(Collectors.toList());

            RoomUserInfoExample roomUserInfoExample = new RoomUserInfoExample();
            RoomUserInfoExample.Criteria roomUserCriteria = roomUserInfoExample.createCriteria();
            roomUserCriteria.andUserIdIn(userIdList);
            List<RoomUserInfo> roomUserInfoList = roomUserInfoDao.selectByExample(roomUserInfoExample);
            responseList = responseList.stream()
                    .map(response -> roomUserInfoList.stream()
                            .filter(roomUserInfo -> Objects.equals(roomUserInfo.getUserId(), response.getUserId()))
                            .findFirst()
                            .map(roomUserInfo -> {
                                response.setRoomId(roomUserInfo.getRoomId());
                                return response;
                            }).orElse(response))
                    .collect(Collectors.toList());

            List<Integer> roomIdList = roomUserInfoList.stream()
                    .map(roomUserInfo -> roomUserInfo.getId())
                    .distinct().collect(Collectors.toList());

            RoomInfoExample roomInfoExample = new RoomInfoExample();
            RoomInfoExample.Criteria roomInfoCriteria = roomInfoExample.createCriteria();
            roomInfoCriteria.andIdIn(roomIdList);
            List<RoomInfo> roomInfoList = roomInfoDao.selectByExample(roomInfoExample);
            commonService.matchRoomInfoToResponse(responseList, roomInfoList);

            BuildingRoomInfoExample buildingRoomInfoExample = new BuildingRoomInfoExample();
            BuildingRoomInfoExample.Criteria buildingRoomCriteria = buildingRoomInfoExample.createCriteria();
            buildingRoomCriteria.andRoomIdIn(roomIdList);
            List<BuildingRoomInfo> buildingRoomInfoList = buildingRoomInfoDao.selectByExample(buildingRoomInfoExample);

            responseList = responseList.stream()
                    .map(response -> buildingRoomInfoList.stream()
                            .filter(buildingRoomInfo -> Objects.equals(buildingRoomInfo.getRoomId(), response.getRoomId()))
                            .findFirst()
                            .map(buildingRoomInfo -> {
                                response.setBuildingId(buildingRoomInfo.getBuildingId());
                                return response;
                            }).orElse(response))
                    .collect(Collectors.toList());

            List<Integer> buildingIds = buildingRoomInfoList.stream()
                    .map(buildingRoomInfo -> buildingRoomInfo.getBuildingId())
                    .distinct().collect(Collectors.toList());

            BuildingInfoExample buildingInfoExample = new BuildingInfoExample();
            BuildingInfoExample.Criteria buildingInfoCriteria = buildingInfoExample.createCriteria();
            buildingInfoCriteria.andIdIn(buildingIds);
            List<BuildingInfo> buildingInfoList = buildingInfoDao.selectByExample(buildingInfoExample);

            responseList = responseList.stream()
                    .map(response -> buildingInfoList.stream()
                            .filter(buildingInfo -> Objects.equals(buildingInfo.getId(), response.getBuildingId()))
                            .findFirst()
                            .map(buildingInfo -> {
                                response.setCityName(buildingInfo.getCityName());
                                response.setAreaName(buildingInfo.getAreaName());
                                response.setStreetName(buildingInfo.getStreetName());
                                response.setVillageName(buildingInfo.getVillageName());
                                response.setBuildingName(buildingInfo.getBuildingDesc());
                                return response;
                            }).orElse(response))
                    .collect(Collectors.toList());
            BeanUtils.copyProperties(pageBean, responsePage);
            responsePage.setList(responseList);
        }else {
            List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
            List<Integer> roomIdList = baseResponseList.stream()
                    .map(baseResponse -> baseResponse.getRoomId())
                    .collect(Collectors.toList());
            List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(roomIdList, request.getStatus());

            RoomUserInfoExample roomUserInfoExample = new RoomUserInfoExample();
            RoomUserInfoExample.Criteria roomUserCriteria = roomUserInfoExample.createCriteria();
            roomUserCriteria.andRoomIdIn(roomIdList);
            if(request.getStatus() != null && request.getStatus() != 0){
                roomUserCriteria.andBindStatusEqualTo(request.getStatus());
            }
            PageHelper.startPage(request.getPage(), request.getLimit());
            List<RoomUserInfo> roomUserInfoList= roomUserInfoDao.selectByExample(roomUserInfoExample);
            PageBean<RoomUserInfo> pageBean = new PageBean<>(roomUserInfoList);

            List<Integer> userIds = roomUserInfoList.stream().map(roomUserInfo -> roomUserInfo.getUserId()).collect(Collectors.toList());
            List<UserInfo> userInfoList = getUserInfosByIds(userIds, request.getStatus());

            List<UserBaseAndAddressInfoResponse> responseList = userInfoList.stream()
                    .map(userInfo -> {
                        UserBaseAndAddressInfoResponse response = new UserBaseAndAddressInfoResponse();
                        response.setUserId(userInfo.getId());
                        response.setUsername(userInfo.getUsername());
                        response.setUserMobile(userInfo.getUserMobile());
                        response.setUserIdCard(userInfo.getUserIdCard());
                        response.setStatus(userInfo.getStatus() == 0 ? "退租" : "在租");
                        response.setRentBeginTime(DateUtil.format(userInfo.getRentBeginTime(), DateUtil.yyyy_MM_dd));
                        response.setRentEndTime(DateUtil.format(userInfo.getRentEndTime(), DateUtil.yyyy_MM_dd));
                        return response;
                    })
                    .collect(Collectors.toList());


            responseList = responseList.stream()
                    .map(response -> roomUserInfoList.stream()
                            .filter(roomUserInfo -> Objects.equals(roomUserInfo.getUserId(), response.getUserId()))
                            .findFirst()
                            .map(roomUserInfo -> {
                                response.setRoomId(roomUserInfo.getRoomId());
                                return response;
                            }).orElse(response))
                    .collect(Collectors.toList());

            commonService.matchRoomInfoToResponse(responseList, roomInfoList);

            commonService.coverBaseInfoToResponse(responseList, baseResponseList);
            BeanUtils.copyProperties(pageBean, responsePage);
            responsePage.setList(responseList);
        }
        return responsePage;
    }



    /*-------------------------------------------------------------------私有方法----------------------------------------------------------------------------------------*/



    private List<RoomUserInfo> getRoomUserInfosByRoomIds(List<Integer> validRoomIds) {
        RoomUserInfoExample roomUserInfoExample = new RoomUserInfoExample();
        RoomUserInfoExample.Criteria roomUserInfoCriteria = roomUserInfoExample.createCriteria();
        roomUserInfoCriteria.andRoomIdIn(validRoomIds);
        roomUserInfoCriteria.andBindStatusEqualTo(1);
        return roomUserInfoDao.selectByExample(roomUserInfoExample);
    }

    private List<UserInfo> getUserInfosByIds(List<Integer> userIds, Integer status) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
        userInfoCriteria.andIdIn(userIds);
        if(status != null){
            userInfoCriteria.andStatusEqualTo(status);
        }
        return userInfoDao.selectByExample(userInfoExample);
    }

    // 获取单个楼栋ID的所有房间信息
    private PageBean<RoomInfo> getRoomInfosByBuildingId(Integer buildingId, Integer status, Integer page, Integer limit){
        // 楼栋和房间关联信息查询
        BuildingRoomInfoExample example = new BuildingRoomInfoExample();
        BuildingRoomInfoExample.Criteria criteria = example.createCriteria();
        criteria.andBuildingIdEqualTo(buildingId);
        List<BuildingRoomInfo> buildingRoomInfos = buildingRoomInfoDao.selectByExample(example);
        if(CollectionUtils.isEmpty(buildingRoomInfos)){
            log.info("buildingRoomInfos 楼栋ID错误，buildingId = {}", buildingId);
            throw new RuntimeException("楼栋ID无效");
        }
        List<Integer> roomIds = buildingRoomInfos.stream()
                .map(buildingRoomInfo -> buildingRoomInfo.getRoomId())
                .collect(Collectors.toList());

        PageBean<RoomInfo> pageBean = commonService.getRoomPageInfosByIds(roomIds, status, page, limit);
        return pageBean;
    }



    /**
     * 添加房间基本数据记录
     * @param request
     * @param status  0：退租  1：签约   2：续租
     * @return
     */
    private int addRoomRentDataInfo(AddRoomRentBaseInfoRequest request, Integer status){
        RoomInfo roomInfo = roomInfoDao.selectByPrimaryKey(request.getRoomId());
        Integer oldEnergyNum = roomInfo.getEnergyNum();
        Integer oldWaterNum = roomInfo.getWaterNum();
        // 更新房间基本信息
        roomInfo.setEnergyNum(request.getEnergyNum());
        roomInfo.setWaterNum(request.getWaterNum());
        // 需要修改的时候传值就修改
        if(request.getOpenInternet() != null){
            roomInfo.setOpenInternet(request.getOpenInternet());
        }
        //如果是档口
        if(roomInfo.getRoomType() == 2){
            if(request.getWaterUnit() != null){
                roomInfo.setWaterUnit(request.getWaterUnit());
            }
            if(request.getEnergyUnit() != null){
                roomInfo.setEnergyUnit(request.getEnergyUnit());
            }
        }
        roomInfo.setModifyTime(new Date());
        if(status == 0 || status == 1){
            roomInfo.setRoomStatus(status);
        }
        roomInfo = roomInfoDal.update(roomInfo);


        /**
         * 放在这里主要是获取roomData数据插入之前的数据
         * 注意：后续可考虑放到里面去，然后roomDatas的list集合取第二条数据
         */
        // 获取最近一次的房间数据记录
        RoomDataExample roomDataExample = new RoomDataExample();
        RoomDataExample.Criteria roomDataCriteria = roomDataExample.createCriteria();
        roomDataExample.setOrderByClause("Fread_time DESC");
        roomDataCriteria.andRoomIdEqualTo(request.getRoomId());
        List<RoomData> roomDatas = roomDataDao.selectByExample(roomDataExample);

        RoomData roomData = new RoomData();
        roomData.setRoomId(roomInfo.getId());
        roomData.setRent(roomInfo.getRent());
        roomData.setEnergyNum(request.getEnergyNum());
        roomData.setWaterNum(request.getWaterNum());
        roomData.setOpenInternet(roomInfo.getOpenInternet());
        roomData.setRentStatus(status);
        // 计算用水量和用电量
        int energyUseCount = request.getEnergyNum() - oldEnergyNum;
        int waterUseCount = request.getWaterNum() - oldWaterNum;
        roomData.setEnergyUseCount(energyUseCount);
        roomData.setWaterUseCount(waterUseCount);
        try {
            roomData.setReadTime(DateUtil.parse(request.getReadTime(), DateUtil.yyyy_MM_dd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();
        roomData.setCreateTime(now);
        roomData.setModifyTime(now);
        int roomId = roomDataDao.insertSelective(roomData);

        // 退租和续约类型的房间数据上报时，需要生成房间费用单
        if(status == 0 || status == 2){
            if(CollectionUtils.isEmpty(roomDatas)){
                log.info("历史房间记录里为空，roomDatas size = {}", roomDatas.size());
            }
            RoomData beforeRoomDatas = roomDatas.get(0);
            BuildingInfo buildingInfo = commonService.getBuildingInfoByRoomId(request.getRoomId());

            RoomFee roomFee = new RoomFee();
            roomFee.setRoomId(roomInfo.getId());
            roomFee.setManageFee(buildingInfo.getManageFee());
            roomFee.setCleanFee(buildingInfo.getCleanFee());
            if(roomInfo.getOpenInternet() == 1){
                roomFee.setInternetFee(buildingInfo.getInternetFee());
            }
            roomFee.setRentFee(roomInfo.getRent());
            if(roomInfo.getRoomType() == 2){ //档口
                roomFee.setEnergyFee(BigDecimal.valueOf(energyUseCount).multiply(roomInfo.getEnergyUnit()));
                roomFee.setWaterFee(BigDecimal.valueOf(waterUseCount).multiply(roomInfo.getWaterUnit()));
            }else{  //住房
                roomFee.setEnergyFee(BigDecimal.valueOf(energyUseCount * UnitPriceConstant.ENERGY_UNIT_PRICE));
                roomFee.setWaterFee(BigDecimal.valueOf(waterUseCount * UnitPriceConstant.WATER_UNIT_PRICE));
            }
            roomFee.setAllFee(roomFee.getWaterFee() //水费
                    .add(roomFee.getEnergyFee())   //电费
                    .add(roomFee.getInternetFee() == null ? new BigDecimal(0) : BigDecimal.valueOf(roomFee.getInternetFee()))   //网费
                    .add(roomFee.getCleanFee() == null ? new BigDecimal(0) : BigDecimal.valueOf(roomFee.getCleanFee()))    //卫生费
                    .add(BigDecimal.valueOf(roomFee.getRentFee()))   //房间租金
                    .add(BigDecimal.valueOf(roomFee.getManageFee())));

            roomFee.setStartFeeTime(beforeRoomDatas.getReadTime());
            try {
                roomFee.setEndFeeTime(DateUtil.parse(request.getReadTime(), DateUtil.yyyy_MM_dd));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date createTime = new Date();
            roomFee.setCreateTime(createTime);
            roomFee.setModifyTime(createTime);
            roomFeeDao.insertSelective(roomFee);
        }
        return roomId;
    }

}
