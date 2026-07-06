package com.project.todolist.exceptions;

public class TaskAlreadyCompletedException extends RuntimeException{

    public TaskAlreadyCompletedException(){
        super("Operação inválida: tarefa já concluida");
    }
}
