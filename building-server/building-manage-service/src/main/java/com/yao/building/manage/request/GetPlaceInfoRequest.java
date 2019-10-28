package com.yao.building.manage.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetPlaceInfoRequest {
    @NotNull
    private Integer pId;
}
