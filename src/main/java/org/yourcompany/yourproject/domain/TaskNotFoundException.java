package org.yourcompany.yourproject.domain;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId taskId) {
        super("Task not found with id: " + taskId);
    }
}