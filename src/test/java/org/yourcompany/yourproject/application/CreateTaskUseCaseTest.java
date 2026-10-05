package org.yourcompany.yourproject.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yourcompany.yourproject.application.input.CreateTaskInput;
import org.yourcompany.yourproject.application.output.TaskOutput;
import org.yourcompany.yourproject.domain.Task;
import org.yourcompany.yourproject.domain.TaskRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private CreateTaskUseCase useCase;

    @Test
    void should_create_task_successfully() {
        var input = new CreateTaskInput("Test Task", Optional.of("This is a test task"));

        when(repository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));
        TaskOutput output = useCase.execute(input);

        assertThat(output).isNotNull();
        assertThat(output.id()).isNotNull();
        assertThat(output.title()).isEqualTo("Test Task");
        assertThat(output.description()).contains("This is a test task");

        verify(repository, times(1)).save(any(Task.class));
    }
}