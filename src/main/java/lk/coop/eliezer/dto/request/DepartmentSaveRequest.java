package lk.coop.eliezer.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentSaveRequest {

    private String name;
    private String alias;
    private String createdBy;
    private String modifiedBy;
    private List<EmployeeSaveRequest> employeeSaveRequestList;

}
