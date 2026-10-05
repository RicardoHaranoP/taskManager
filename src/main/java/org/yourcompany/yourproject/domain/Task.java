package org.yourcompany.yourproject.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
public class Task {
    private TaskId id;
    private String title;
    private Optional<String> description;
    private TaskStatus status;

    public Task(String title, Optional<String> description) {
        this(title, description, TaskStatus.PENDING);
    }

    public Task(String title, Optional<String> description, TaskStatus status) {
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.id = new TaskId();
        this.description = Objects.requireNonNull(description, "Description cannot be null");
        this.status = Objects.requireNonNull(status, "Status cannot be null");
    }

    public void update(Optional<String> title, Optional<String> description, Optional<String> status) {
        title.ifPresent(this::setTitle);
        description.ifPresent(d -> setDescription(Optional.of(d)));
        status.map(TaskStatus::valueOf).ifPresent(this::setStatus);
    }

}