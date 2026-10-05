package org.yourcompany.yourproject.infrastructure.http.request;

import org.yourcompany.yourproject.application.input.CreateTaskInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateTaskRequest(
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    String title,
    @Size(max = 200, message = "Description must not exceed 200 characters")
    String description
) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(
            title,
            Optional.ofNullable(description)
        );
    }
}