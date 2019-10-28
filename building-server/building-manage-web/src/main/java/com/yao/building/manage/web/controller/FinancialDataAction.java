package com.yao.building.manage.web.controller;

import com.yao.building.manage.request.GetFinanceInfoRequest;
import com.yao.building.manage.response.FinancialInfoResponse;
import com.yao.building.manage.service.FinanceInfoService;
import com.yao.building.manage.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/building/financial")
public class FinancialDataAction {
    @Autowired
    private FinanceInfoService financeInfoService;

    @RequestMapping("getFinanceInfos")
    public PageBean<FinancialInfoResponse> getFinanceInfoList(@RequestBody GetFinanceInfoRequest request) {
        return financeInfoService.getFinancialInfoByConditions(request);
    }
}
