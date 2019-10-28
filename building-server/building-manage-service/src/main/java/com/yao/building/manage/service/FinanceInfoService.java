package com.yao.building.manage.service;

import com.yao.building.manage.request.GetFinanceInfoRequest;
import com.yao.building.manage.response.FinancialInfoResponse;
import com.yao.building.manage.vo.PageBean;

public interface FinanceInfoService {
    /**
     * 财务报表统计
     */
    PageBean<FinancialInfoResponse> getFinancialInfoByConditions(GetFinanceInfoRequest request);
}
