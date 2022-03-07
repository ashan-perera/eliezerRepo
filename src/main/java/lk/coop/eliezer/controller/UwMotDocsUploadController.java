package lk.coop.eliezer.controller;

import io.dekorate.deps.commons.compress.utils.IOUtils;
import lk.coop.eliezer.dto.response.UwMotDocsUploadResponse;
import lk.coop.eliezer.service.UwMotDocsUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("uwMotDocsUpload")
@RestController
@CrossOrigin
public class UwMotDocsUploadController {

    @Autowired
    private UwMotDocsUploadService uwMotDocsUploadService;

    @PostMapping
    public ResponseEntity<UwMotDocsUploadResponse> save(@Valid @RequestParam("UwMotDocsUpload") String request,
                                                        @RequestParam("UwMotDocs") MultipartFile uwMotDocs){

        UwMotDocsUploadResponse save = uwMotDocsUploadService.save(request,uwMotDocs);
        return ResponseEntity.ok(save);
    }

    @GetMapping("ImageFile/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable("id") String id) throws IOException {

        File imgFile = uwMotDocsUploadService.getImageById(id);

        InputStream is = new FileInputStream(imgFile);
        byte[] fileBytes = IOUtils.toByteArray(is);
        ByteArrayResource resource = new ByteArrayResource(fileBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control","no-cache, no-store, must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        headers.add("Content-Disposition","attachment; filename=" + imgFile.getName());
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(imgFile.length())
                .contentType(MediaType.parseMediaType("application/jpg")).body(resource);

    }

}
