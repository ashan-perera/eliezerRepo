package lk.coop.eliezer.service;

import lk.coop.eliezer.dto.response.UwMotDocsUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UwMotDocsUploadService {

    UwMotDocsUploadResponse save(String request, MultipartFile uwMotDocs);

    File getImageById(String id);

}
