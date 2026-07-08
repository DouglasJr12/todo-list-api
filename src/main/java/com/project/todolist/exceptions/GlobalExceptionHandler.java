package com.project.todolist.exceptions;

import com.project.todolist.dto.ErrorResponse;
import com.project.todolist.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse errorResponseBuild(HttpStatus status, String message){
        ErrorResponse errorResponse = new ErrorResponse(status, message, LocalDateTime.now());
        return errorResponse;
    }

    private ErrorResponse errorResponseBuild(HttpStatus status, String message, List<ValidationError> errors){
        ErrorResponse errorResponse = new ErrorResponse(status, message, LocalDateTime.now(), errors);
        return errorResponse;
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseBuild(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(TaskAlreadyCompletedException.class)
    public ResponseEntity<ErrorResponse> handleTaskAlreadyCompleted(TaskAlreadyCompletedException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseBuild(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(TaskAlreadyCancelledException.class)
    public ResponseEntity<ErrorResponse> handleTaskAlreadyCancelled(TaskAlreadyCancelledException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseBuild(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> inRequestValidationException(MethodArgumentNotValidException requestErrorValidation) {
        List<ValidationError> errorList = new ArrayList<>();
        for (FieldError erro : requestErrorValidation.getBindingResult().getFieldErrors()) {
            ValidationError validationError = new ValidationError(erro.getField(), erro.getDefaultMessage());
            errorList.add(validationError);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseBuild(HttpStatus.BAD_REQUEST, "ERRO DE VALIDAÇÃO",errorList));

    }
}