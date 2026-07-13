package com.project.todolist.exceptions;

public class InvalidDeadlineException extends RuntimeException{
    public InvalidDeadlineException(){
        super("A data limite não pode estar no passado ou ser superior a um ano.");
    }
}
