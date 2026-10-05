package org.yourcompany.yourproject.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.yourcompany.yourproject.application.output.TaskOutput;
import org.yourcompany.yourproject.domain.TaskRepository;

@Service
public class GetTasksUseCase {
    private final TaskRepository repository;

    public GetTasksUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute() {
        return repository.findAll().stream()
                .map(TaskOutput::fromTask)
                .toList();
    }
}
