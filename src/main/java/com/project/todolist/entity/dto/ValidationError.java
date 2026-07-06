package com.project.todolist.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ValidationError {

    private String field;

    private String message;

}
