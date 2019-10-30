package com.yao.building.manage.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlaceInfoRequest {
    /**
     * pId <= 100000   为地区id
     * pId > 100000    为buildingId
     */
    @NotNull
    private Integer pId;
}
