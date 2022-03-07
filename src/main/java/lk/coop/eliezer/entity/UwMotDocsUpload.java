package lk.coop.eliezer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "UW_MOT_DOCS_UPLOAD")
public class UwMotDocsUpload extends BaseEntity {

    @Column(name = "VEHICLE_NUMBER", nullable = false, length = 50)
    private String vehicleNumber ;

    @Column(name = "REFERENCE_NUMBER", nullable = false, length = 20)
    private String referenceNumber;

    @Column(name = "CATEGORY", nullable = false, length = 20)
    private String category;

    @Column(name = "FILE_NAME", nullable = false, length = 50)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false, length = 500)
    private String filePath;

    @Column(name = "IMAGE_TAG", nullable = false, length = 500)
    private String imageTag;

    @Column(name = "INACTIVE_REASON", length = 50)
    private String inactiveReason;

}
