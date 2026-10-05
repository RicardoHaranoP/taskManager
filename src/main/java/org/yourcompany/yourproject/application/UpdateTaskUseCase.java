package org.yourcompany.yourproject.application;

import org.yourcompany.yourproject.application.input.UpdateTaskInput;
import org.yourcompany.yourproject.application.output.TaskOutput;
import org.yourcompany.yourproject.domain.TaskRepository;
import org.springframework.stereotype.Service;
import org.yourcompany.yourproject.domain.TaskId;
import org.yourcompany.yourproject.domain.TaskNotFoundException;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.fromTask(updated);
    }
}
