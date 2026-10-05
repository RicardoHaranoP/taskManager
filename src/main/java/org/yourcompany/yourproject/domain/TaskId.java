package org.yourcompany.yourproject.domain;

import java.util.UUID;
import java.util.Objects;

public record TaskId(UUID id) {
    public TaskId {
        Objects.requireNonNull(id, "TaskId cannot be null");
    }

    public TaskId() {
        this(UUID.randomUUID());
    }
}