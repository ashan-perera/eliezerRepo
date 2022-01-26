package lk.coop.eliezer.dto.response;

import lk.coop.eliezer.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class DepartmentResponse {

    private String id;
    private String name;
    private String alias;
    private String createdBy;
    private String modifiedBy;
    private Date createdDateTime;
    private Date modifiedDateTime;
    private Status status;

}
