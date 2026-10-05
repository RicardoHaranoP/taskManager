package org.yourcompany.yourproject.infrastructure.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yourcompany.yourproject.domain.Task;
import org.yourcompany.yourproject.domain.TaskId;
import org.yourcompany.yourproject.domain.TaskRepository;
import org.yourcompany.yourproject.domain.TaskStatus;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TaskRepositoryTest {
    TaskRepository repository;

    protected abstract TaskRepository createRepository();

    @BeforeEach
    public void setUp() {
        repository = createRepository();
    }

    @Test
    void should_save_and_retrieve_task_by_id() {
        var task = new Task("Passar no mercado", Optional.empty());
        var saved = repository.save(task);
        Optional<Task> result = repository.findById(saved.getId());
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(task.getId());
        assertThat(result.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result.get().getStatus()).isEqualTo(task.getStatus());
    }

    @Test
    void should_find_all_persisted_tasks() {
        var task1 = new Task("Arrumar chuveiro", Optional.of("Comprar chuveiro novo"));
        var task2 = new Task("Trocar resistência", Optional.of("Comprar resistência nova"));
        repository.save(task1);
        repository.save(task2);
        List<Task> result = repository.findAll();
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Task::getId).containsExactlyInAnyOrder(task1.getId(), task2.getId());
    }

    @Test
    void should_delete_task_by_id() {
        var task = repository.save(new Task("Limpar a casa", Optional.empty()));
        var taskId = task.getId();
        repository.delete(taskId);
        Optional<Task> result = repository.findById(taskId);
        assertThat(result).isEmpty();
    }

    @Test
    void should_return_empty_when_searching_non_existent_task() {
        var nonExistentTaskId = new TaskId();
        Optional<Task> result = repository.findById(nonExistentTaskId);
        assertThat(result).isEmpty();
    }

    @Test
    void should_update_task_status_successfully() {
        var task = repository.save(new Task("Estudar Java", Optional.empty()));
        task.setDescription(Optional.of("Atualizando status"));
        task.setStatus(TaskStatus.IN_PROGRESS);
        repository.save(task);
        Optional<Task> result = repository.findById(task.getId());
        assertThat(result).isPresent();
        assertThat(result.get().getDescription()).isEqualTo(Optional.of("Atualizando status"));
        assertThat(result.get().getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }
}
