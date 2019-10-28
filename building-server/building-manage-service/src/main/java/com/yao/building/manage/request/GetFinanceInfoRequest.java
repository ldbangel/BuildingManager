package com.yao.building.manage.request;

import com.yao.building.manage.request.PageRequest.BaseRequest;
import lombok.Data;

@Data
public class GetFinanceInfoRequest extends BaseRequest {
    private String beginTime;
    private String endTime;
}
