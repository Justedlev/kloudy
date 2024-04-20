package dev.justedlev.kloudy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AttachmentResponse {
    private String filename;
    private String extension;
    @Builder.Default
    private MediaType contentType = MediaType.APPLICATION_OCTET_STREAM;
    @Builder.Default
    private Long length = 0L;
    private Resource resource;
    @Builder.Default
    private HttpHeaders headers = new HttpHeaders();

    public ResponseEntity<Resource> toResponseEntity() {
        getHeaders().add(HttpHeaders.CONTENT_DISPOSITION, getContentDisposition());

        return ResponseEntity.ok()
                .headers(getHeaders())
                .contentLength(getLength())
                .contentType(getContentType())
                .body(getResource());
    }

    private String getContentDisposition() {
        return ContentDisposition.builder(getType())
                .filename(getFilename())
                .build()
                .toString();
    }

    private String getType() {
        return Optional.ofNullable(getContentType())
                .map(MediaType::getType)
                .filter(type -> StringUtils.containsAnyIgnoreCase(type, "video", "image", "audio"))
                .map(c -> "inline")
                .orElse("attachment");
    }
}
