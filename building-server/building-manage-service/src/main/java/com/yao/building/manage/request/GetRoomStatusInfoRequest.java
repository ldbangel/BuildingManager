package com.yao.building.manage.request;

import com.yao.building.manage.request.PageRequest.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetRoomStatusInfoRequest extends BaseRequest {
    @NotNull
    private Integer status;
}
