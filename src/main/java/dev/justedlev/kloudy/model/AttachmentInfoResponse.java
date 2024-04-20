package dev.justedlev.kloudy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AttachmentInfoResponse {
    private UUID id;
    private String filename;
    private String mimeType;
    private Long length;
}
