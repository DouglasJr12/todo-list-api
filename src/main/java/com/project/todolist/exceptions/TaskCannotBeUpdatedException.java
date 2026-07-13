package com.project.todolist.exceptions;

public class TaskCannotBeUpdatedException extends RuntimeException{
    public TaskCannotBeUpdatedException(){
        super("A tarefa não pode ser alterada devido ao seu status atual.");
    }
}
