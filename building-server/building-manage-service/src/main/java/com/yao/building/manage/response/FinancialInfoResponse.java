package com.yao.building.manage.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialInfoResponse extends BaseResponse{
    private Integer roomId;
    private Integer roomNo;
    private BigDecimal allFee;
    private Integer manageFee;
    private Integer rentFee;
    private BigDecimal energyFee;
    private BigDecimal waterFee;
    private String endFeeTime;
}
