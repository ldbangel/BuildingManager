package com.yao.building.manage.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialInfoResponse extends BaseResponse{
    private Integer roomId;
    private Integer roomNo;
    /**
     * 总费用
     */
    private BigDecimal allFee;
    /**
     * 管理费
     */
    private Integer manageFee;
    /**
     * 租金
     */
    private Integer rentFee;
    /**
     * 电费
     */
    private BigDecimal energyFee;
    /**
     * 水费
     */
    private BigDecimal waterFee;
    /**
     * 卫生费
     */
    private Integer cleanFee;
    /**
     * 网费
     */
    private Integer internetFee;
    /**
     * 截止日期
     */
    private String endFeeTime;
}
