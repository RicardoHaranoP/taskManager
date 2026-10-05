package org.yourcompany.yourproject.application;

import org.yourcompany.yourproject.domain.TaskId;
import org.yourcompany.yourproject.domain.TaskRepository;
import org.yourcompany.yourproject.application.output.TaskOutput;
import org.springframework.stereotype.Service;
import org.yourcompany.yourproject.domain.TaskNotFoundException;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId taskId) {
        var task = repository.findById(taskId)
            .orElseThrow(() -> new TaskNotFoundException(taskId));
        return TaskOutput.fromTask(task);
    }
}
