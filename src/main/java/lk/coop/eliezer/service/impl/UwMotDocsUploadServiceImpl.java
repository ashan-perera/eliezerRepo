package lk.coop.eliezer.service.impl;

import lk.coop.eliezer.dto.request.UwMotDocsUploadRequest;
import lk.coop.eliezer.dto.response.UwMotDocsUploadResponse;
import lk.coop.eliezer.entity.UwMotDocsUpload;
import lk.coop.eliezer.enums.Status;
import lk.coop.eliezer.repository.UwMotDocsUploadRepository;
import lk.coop.eliezer.service.UwMotDocsUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
public class UwMotDocsUploadServiceImpl implements UwMotDocsUploadService {

    @Autowired
    private UwMotDocsUploadRepository uwMotDocsUploadRepository;

    @Transactional
    @Override
    public UwMotDocsUploadResponse save(String request, MultipartFile uwMotDocs) {

        Gson gson = new Gson();
        UwMotDocsUploadRequest uwMotDocsUploadRequest = gson.fromJson(request, UwMotDocsUploadRequest.class);

        Instant instant = Instant.now();
        String fileName = instant.toEpochMilli() + ".jpg";

        File dir = new File(System.getProperty("user.home") + "/Appz/UW/Motor/" + uwMotDocsUploadRequest.getVehicleNumber() + "/" + uwMotDocsUploadRequest.getReferenceNumber() + "/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        File dir = new File("C:\\Apps\\UW\\Motor\\" + uwMotDocsUploadRequest.getVehicleNumber() + "\\" + uwMotDocsUploadRequest.getReferenceNumber() + "\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dir.mkdirs();

//        try {
//            mpfile.transferTo(new File(dir, fileName));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        File imageFile = new File(dir, fileName);

        try {
            uwMotDocs.transferTo(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UwMotDocsUpload uwMotDocsUpload = new UwMotDocsUpload();

        uwMotDocsUpload.setVehicleNumber(uwMotDocsUploadRequest.getVehicleNumber());
        uwMotDocsUpload.setReferenceNumber(uwMotDocsUploadRequest.getReferenceNumber());
        uwMotDocsUpload.setCategory(uwMotDocsUploadRequest.getCategory());
        uwMotDocsUpload.setFileName(fileName);
        uwMotDocsUpload.setFilePath(imageFile.getAbsolutePath());
        uwMotDocsUpload.setImageTag(uwMotDocsUploadRequest.getImageTag());
        uwMotDocsUpload.setInactiveReason(uwMotDocsUploadRequest.getInactiveReason());
        uwMotDocsUpload.setCreatedBy(uwMotDocsUploadRequest.getCreatedBy());
        uwMotDocsUpload.setModifiedBy(uwMotDocsUploadRequest.getModifiedBy());
        uwMotDocsUpload.setStatus(Status.ACTIVE);

        UwMotDocsUpload save = uwMotDocsUploadRepository.save(uwMotDocsUpload);

        return convert(save);
    }

    @Override
    public File getImageById(String id) {

        UwMotDocsUpload uwMotDocsUpload = uwMotDocsUploadRepository.getById(id);
        File imgFile = new File(uwMotDocsUpload.getFilePath());

        return imgFile;
    }

    private static UwMotDocsUploadResponse convert(UwMotDocsUpload uwMotDocsUpload) {

        UwMotDocsUploadResponse uwMotDocsUploadResponse = new UwMotDocsUploadResponse();

        uwMotDocsUploadResponse.setId(uwMotDocsUpload.getId());
        uwMotDocsUploadResponse.setVehicleNumber(uwMotDocsUpload.getVehicleNumber());
        uwMotDocsUploadResponse.setReferenceNumber(uwMotDocsUpload.getReferenceNumber());
        uwMotDocsUploadResponse.setCategory(uwMotDocsUpload.getCategory());
        uwMotDocsUploadResponse.setFileName(uwMotDocsUpload.getFileName());
        uwMotDocsUploadResponse.setFilePath(uwMotDocsUpload.getFilePath());
        uwMotDocsUploadResponse.setCreatedBy(uwMotDocsUpload.getCreatedBy());
        uwMotDocsUploadResponse.setCreatedDateTime(uwMotDocsUpload.getCreatedDateTime());
        uwMotDocsUploadResponse.setModifiedBy(uwMotDocsUpload.getModifiedBy());
        uwMotDocsUploadResponse.setModifiedDateTime(uwMotDocsUpload.getModifiedDateTime());
        uwMotDocsUploadResponse.setStatus(uwMotDocsUpload.getStatus());
        uwMotDocsUploadResponse.setInactiveReason(uwMotDocsUpload.getInactiveReason());
        uwMotDocsUploadResponse.setImageTag(uwMotDocsUpload.getImageTag());

        return uwMotDocsUploadResponse;

    }

}
