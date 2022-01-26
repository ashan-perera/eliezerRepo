package lk.coop.eliezer.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeSaveRequest {

    private String firstName;
    private String lastName;
    private String epf;
    private String departmentId;
    private Date dob;
    private String createdBy;
    private String modifiedBy;

}
