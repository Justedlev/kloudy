package dev.justedlev.kloudy.service.impl;

import dev.justedlev.kloudy.model.AttachmentInfoResponse;
import dev.justedlev.kloudy.model.AttachmentResponse;
import dev.justedlev.kloudy.service.AttachmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    @Override
    public AttachmentInfoResponse upload(@NonNull MultipartFile files) {
        return null;
    }

    @Override
    public AttachmentInfoResponse delete(UUID id) {
        return null;
    }

    public AttachmentResponse download(UUID id) {
        return null;
    }
}
