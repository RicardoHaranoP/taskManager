package org.yourcompany.yourproject.application;

import org.springframework.stereotype.Service;
import org.yourcompany.yourproject.domain.TaskId;
import org.yourcompany.yourproject.domain.TaskNotFoundException;
import org.yourcompany.yourproject.domain.TaskRepository;


@Service
public class DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(TaskId taskId) {
        if (taskRepository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        taskRepository.delete(taskId);
    }
}
