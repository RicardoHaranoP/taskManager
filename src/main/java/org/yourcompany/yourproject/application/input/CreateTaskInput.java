package org.yourcompany.yourproject.application.input;

import java.util.Optional;

public record CreateTaskInput(String title, Optional<String> description) {

    
}
