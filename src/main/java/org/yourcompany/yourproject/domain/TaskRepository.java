package org.yourcompany.yourproject.domain;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save (Task task);
    Optional<Task> findById(TaskId id);
    List<Task> findAll();
    void delete(TaskId id);
}