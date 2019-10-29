package com.yao.building.manage.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlaceInfoRequest {
    @NotNull
    private Integer pId;
}
