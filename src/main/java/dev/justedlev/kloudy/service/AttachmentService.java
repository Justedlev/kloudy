package dev.justedlev.kloudy.service;

import dev.justedlev.kloudy.model.AttachmentInfoResponse;
import dev.justedlev.kloudy.model.AttachmentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface AttachmentService {
    AttachmentInfoResponse upload(MultipartFile file);

    AttachmentInfoResponse delete(UUID id);

    AttachmentResponse download(UUID id);
}
