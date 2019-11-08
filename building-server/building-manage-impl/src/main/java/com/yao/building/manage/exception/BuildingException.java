package com.yao.building.manage.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingException extends RuntimeException {
    private String code;
    private String message;

    public BuildingException(BuildingErrorCode code){
        this.code = code.getCode();
        this.message = code.getMessage();
    }
}
