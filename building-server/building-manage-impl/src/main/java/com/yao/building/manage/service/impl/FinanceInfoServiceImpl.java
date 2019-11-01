package com.yao.building.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.yao.building.manage.dao.RoomFeeDao;
import com.yao.building.manage.domain.BuildingInfo;
import com.yao.building.manage.domain.RoomFee;
import com.yao.building.manage.domain.RoomFeeExample;
import com.yao.building.manage.domain.RoomInfo;
import com.yao.building.manage.request.GetFinanceInfoRequest;
import com.yao.building.manage.response.BaseResponse;
import com.yao.building.manage.response.FinancialInfoResponse;
import com.yao.building.manage.service.FinanceInfoService;
import com.yao.building.manage.vo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("financeInfoService")
public class FinanceInfoServiceImpl implements FinanceInfoService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private RoomFeeDao roomFeeDao;

    @Override
    public PageBean<FinancialInfoResponse> getFinancialInfoByConditions(GetFinanceInfoRequest request) {
        if(request == null){
            throw new RuntimeException("无效的请求参数");
        }
        List<FinancialInfoResponse> responseList = new ArrayList<>();
        PageBean<FinancialInfoResponse> responsePage = new PageBean<>();

        if(request.getRoomId() != null && request.getRoomId() != 0){
            BuildingInfo buildingInfo = commonService.getBuildingInfoByRoomId(request.getRoomId());
            List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(Arrays.asList(request.getRoomId()), null);

            responsePage = getFinancialRoomFeeInfos(request, responsePage);
            responseList = responsePage.getList();

            List<BuildingInfo> buildingInfoList = new ArrayList<>();
            buildingInfoList.add(buildingInfo);

            commonService.matchRoomInfoToResponse(responseList, roomInfoList);

            responseList.stream()
                    .map(response -> {
                        commonService.coverBuildingInfoToResponse(response, buildingInfo);
                        return response;
                    }).collect(Collectors.toList());
        }else{
            List<BaseResponse> baseResponseList = commonService.getAllRoomIds(request);
            List<Integer> roomIds = baseResponseList.stream().map(baseResponse -> baseResponse.getRoomId()).collect(Collectors.toList());
            List<RoomInfo> roomInfoList = commonService.getRoomInfosByIds(roomIds, null);

            responsePage = getFinancialRoomFeeInfos(request, responsePage);
            responseList = responsePage.getList();

            commonService.matchRoomInfoToResponse(responseList, roomInfoList);
            commonService.coverBaseInfoToResponse(responseList, baseResponseList);
        }
        return responsePage;
    }

    private PageBean<FinancialInfoResponse> getFinancialRoomFeeInfos(GetFinanceInfoRequest request, PageBean<FinancialInfoResponse> responsePage) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RoomFeeExample roomFeeExample = new RoomFeeExample();
        RoomFeeExample.Criteria roomFeeCriteria = roomFeeExample.createCriteria();
        roomFeeCriteria.andRoomIdEqualTo(request.getRoomId());
        if(StringUtils.isNotEmpty(request.getBeginTime())
                && StringUtils.isNotEmpty(request.getEndTime())){
            try {
                roomFeeCriteria.andEndFeeTimeGreaterThanOrEqualTo(format.parse(request.getBeginTime()));
                roomFeeCriteria.andEndFeeTimeLessThanOrEqualTo(format.parse(request.getEndTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<RoomFee> roomFeeList= roomFeeDao.selectByExample(roomFeeExample);
        PageBean<RoomFee> pageBean = new PageBean<>(roomFeeList);
        List<FinancialInfoResponse> responseList = roomFeeList.stream()
                .map(roomFee -> {
                    FinancialInfoResponse response = new FinancialInfoResponse();
                    response.setAllFee(roomFee.getAllFee());
                    response.setEndFeeTime(format.format(roomFee.getEndFeeTime()));
                    response.setEnergyFee(roomFee.getEnergyNum());
                    response.setWaterFee(roomFee.getWaterNum());
                    response.setManageFee(roomFee.getManageFee());
                    response.setRentFee(roomFee.getRentFee());
                    response.setRoomId(roomFee.getRoomId());
                    return response;
                })
                .collect(Collectors.toList());

        BeanUtils.copyProperties(pageBean, responsePage);
        responsePage.setList(responseList);
        return responsePage;
    }
}
