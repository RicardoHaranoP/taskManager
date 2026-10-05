package org.yourcompany.yourproject.application.output;

import org.yourcompany.yourproject.domain.Task;

import java.util.Optional;

public record TaskOutput(String id, String title, Optional<String> description, String status) {
    public static TaskOutput fromTask(Task task) {
        return new TaskOutput(
                task.getId().id().toString(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name()
        );
    }
}
