package org.yourcompany.yourproject.application;

import org.yourcompany.yourproject.domain.Task;
import org.yourcompany.yourproject.domain.TaskRepository;
import org.yourcompany.yourproject.application.input.CreateTaskInput;
import org.yourcompany.yourproject.application.output.TaskOutput;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    public final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var savedTask = repository.save(task);
        return TaskOutput.fromTask(savedTask);
    }
}
