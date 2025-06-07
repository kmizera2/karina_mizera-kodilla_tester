package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Important Tasks", "Tasks that must be done soon");
        taskListRepository.save(taskList);

        // When
        List<TaskList> found = taskListRepository.findByListName("Important Tasks");

        // Then
        assertEquals(1, found.size());
        assertEquals("Important Tasks", found.get(0).getListName());
        assertEquals("Tasks that must be done soon", found.get(0).getDescription());

        // CleanUp
        //CleanUp
        int id = found.get(0).getId();
        taskListRepository.deleteById(id);
    }
}