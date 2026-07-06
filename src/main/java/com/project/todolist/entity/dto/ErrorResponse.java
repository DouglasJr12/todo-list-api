package com.project.todolist.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private LocalDateTime timestamp;

    private List<ValidationError> error;

    public ErrorResponse(HttpStatus status, String message, LocalDateTime timestamp){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }


}
