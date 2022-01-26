package lk.coop.eliezer.dto.response;

import lk.coop.eliezer.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String epf;
    private Date dob;
    private String departmentId;
    private String createdBy;
    private String modifiedBy;
    private Date createdDateTime;
    private Date modifiedDateTime;
    private Status status;

}
