package com.example.Student_MapStruct.Exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ErrorResponse {
    private LocalDateTime localDateTime;
    private int status;
    private List<String> messages;
    private String path;
}
