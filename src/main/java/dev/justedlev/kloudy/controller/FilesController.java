package dev.justedlev.kloudy.controller;

import dev.justedlev.kloudy.model.AttachmentInfoResponse;
import dev.justedlev.kloudy.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/v1/files")
@RequiredArgsConstructor
@Validated
public class FilesController {
    private final AttachmentService attachmentService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AttachmentInfoResponse> upload(@RequestPart MultipartFile file) {
        return ResponseEntity.ok(attachmentService.upload(file));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource> download(@PathVariable UUID id) {
        return attachmentService.download(id).toResponseEntity();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AttachmentInfoResponse> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(attachmentService.delete(id));
    }
}
