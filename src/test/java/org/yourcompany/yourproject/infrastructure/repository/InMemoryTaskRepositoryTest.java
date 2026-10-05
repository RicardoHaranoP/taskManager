package org.yourcompany.yourproject.infrastructure.repository;

import org.yourcompany.yourproject.domain.TaskRepository;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}