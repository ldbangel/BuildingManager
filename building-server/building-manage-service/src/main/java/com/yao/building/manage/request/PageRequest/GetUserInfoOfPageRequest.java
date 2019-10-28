package com.yao.building.manage.request.PageRequest;

import lombok.Data;

import java.util.List;

@Data
public class GetUserInfoOfPageRequest extends BaseRequest {
    private List<Integer> userIds;
    private Integer status;
}
