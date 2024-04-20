package dev.justedlev.kloudy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
public class ErrorDetails implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @lombok.Builder.Default
    private Date timestamp = new Date();
    private String message;
    private String details;
}
