package lk.coop.eliezer.dto.request;

import lk.coop.eliezer.enums.Status;
import lombok.Data;

@Data
public class DepartmentUpdateRequest {

    private String id;
    private String name;
    private String alias;
    private String modifiedBy;
    private Status status;

}
