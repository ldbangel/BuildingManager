package com.yao.building.manage.request.PageRequest;

import lombok.Data;

@Data
public class BaseRequest {
    private Integer cityId;
    private Integer areaId;
    private Integer streetId;
    private Integer villageId;
    private Integer buildingId;
    private Integer roomId;
    /**
     * 房间状态   0：未租   1：在租
     */
    private Integer status;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页数量
     */
    private Integer limit = 20;
}
