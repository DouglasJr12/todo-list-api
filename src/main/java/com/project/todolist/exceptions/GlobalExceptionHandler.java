package com.project.todolist.exceptions;

import com.project.todolist.entity.dto.ErrorResponse;
import com.project.todolist.entity.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(TaskAlreadyCompletedException.class)
    public ResponseEntity<ErrorResponse> handleTaskAlreadyCompleted(TaskAlreadyCompletedException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(TaskAlreadyCancelledException.class)
    public ResponseEntity<ErrorResponse> handleTaskAlreadyCancelled(TaskAlreadyCancelledException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> inRequestValidationException(MethodArgumentNotValidException requestErrorValidation) {
        List<ValidationError> errorList = new ArrayList<>();
        for (FieldError erro : requestErrorValidation.getBindingResult().getFieldErrors()) {
            ValidationError validationError = new ValidationError(erro.getField(), erro.getDefaultMessage());
            errorList.add(validationError);
        }
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Erro de validação", LocalDateTime.now(), errorList);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }
}