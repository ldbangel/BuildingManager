package com.yao.building.manage.response;

import com.yao.building.manage.vo.EmployeeEntry;
import lombok.Data;

import java.util.List;

@Data
public class BuildingAndEmployeeInfoResponse extends BaseResponse {
    private List<EmployeeEntry> employeeEntries;
}
