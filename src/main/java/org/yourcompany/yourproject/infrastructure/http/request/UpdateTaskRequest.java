package org.yourcompany.yourproject.infrastructure.http.request;

import java.util.Optional;

import org.yourcompany.yourproject.application.input.UpdateTaskInput;

public record UpdateTaskRequest (Optional<String> title, Optional<String> description, Optional<String> status) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status);
    }
}
