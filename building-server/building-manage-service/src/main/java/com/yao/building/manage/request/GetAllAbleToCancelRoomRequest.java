package com.yao.building.manage.request;

import com.yao.building.manage.request.PageRequest.BaseRequest;
import lombok.Data;

@Data
public class GetAllAbleToCancelRoomRequest extends BaseRequest {
    private Integer buildingId;
}
