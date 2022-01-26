package lk.coop.eliezer.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeUpdateRequest {

    private String id;
    private String firstName;
    private String lastName;
    private String epf;
    private Date dob;
    private String departmentId;
    private String createdBy;
    private String modifiedBy;
    private String status;

}
