package lk.coop.eliezer.dto.response;

import lk.coop.eliezer.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class UwMotDocsUploadResponse {

    private String id;
    private String vehicleNumber;
    private String referenceNumber;
    private String category;
    private String fileName;
    private String filePath;
    private String createdBy;
    private Date createdDateTime;
    private String modifiedBy;
    private Date modifiedDateTime;
    private Status status;
    private String inactiveReason;
    private String imageTag;

}
