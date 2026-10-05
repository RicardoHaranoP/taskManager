package org.yourcompany.yourproject.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.yourcompany.yourproject.application.output.TaskOutput;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaskResponse (String id, String title, String description, String status) {
    public static TaskResponse from(TaskOutput output) {
        return new TaskResponse(output.id(), output.title(), output.description().orElse(null), output.status());
    }    
}
