package com.example.testing.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testing.data.Task
import com.example.testing.data.source.FakeTaskRepository
import com.example.testing.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull.nullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    lateinit var viewModel: TasksViewModel
    private lateinit var tasksRepository: FakeTaskRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUpViewModel() {
        tasksRepository = FakeTaskRepository()
        val task1 = Task("Title1", "Description1")
        val task2 = Task("Title2", "Description2", true)
        val task3 = Task("Title3", "Description3", true)
        tasksRepository . addTasks (task1, task2, task3)
        viewModel = TasksViewModel(tasksRepository)
    }

    //SubjectUnderTest_actionOrInput_resultState
    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh ViewModel

        // When adding a new task
        viewModel.addNewTask()

        // Then the new task event is triggered
        val value = viewModel.newTaskEvent.getOrAwaitValue()
        assertThat(
            value.getContentIfNotHandled(), (not(nullValue()))
        )
    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {
        //Given a viewmodel

        //When adding a filter of
        viewModel.setFiltering(TasksFilterType.ALL_TASKS)

        //Then
        val value = viewModel.tasksAddViewVisible.getOrAwaitValue()
        assertThat(value, `is`(true))


    }
}