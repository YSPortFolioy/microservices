package com.youssadi.dto.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter @Setter
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String path;

    public ErrorResponse(Date timestamp, String message, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
    }
}
