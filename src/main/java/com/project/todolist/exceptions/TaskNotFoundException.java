package com.project.todolist.exceptions;


public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(){
        super("Tarefa Não encontrada");
    }


}
