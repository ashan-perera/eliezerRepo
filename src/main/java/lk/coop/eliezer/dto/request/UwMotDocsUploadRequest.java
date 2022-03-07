package lk.coop.eliezer.dto.request;

import lombok.Data;

@Data
public class UwMotDocsUploadRequest {

    private String vehicleNumber;
    private String referenceNumber;
    private String category;
    private String imageTag;
    private String inactiveReason;
    private String createdBy;
    private String modifiedBy;

}
