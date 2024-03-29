package com.example.testing.data.source

import com.example.testing.data.Result
import com.example.testing.data.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

class DefaultTasksRepositoryTest{
    private val task1 = Task("Title1", "Description1")
    private val task2 = Task("Title2", "Description2")
    private val task3 = Task("Title3", "Description3")
    private val remoteTasks = listOf(task1, task2).sortedBy { it.id }
    private val localTasks = listOf(task3).sortedBy { it.id }
    private val newTasks = listOf(task3).sortedBy { it.id }

    private lateinit var tasksRepository: DefaultTasksRepository
    private lateinit var tasksRemoteDataSource: FakeDataSource
    private lateinit var tasksLocalDataSource: FakeDataSource

    @Before
    fun createRepository() {
        tasksRemoteDataSource = FakeDataSource(remoteTasks.toMutableList())
        tasksLocalDataSource = FakeDataSource(localTasks.toMutableList())
        // Get a reference to the class under test
        // TODO Dispatchers.Unconfined should be replaced with Dispatchers.Main
        // this requires understanding more about coroutines + testing
        // so we will keep this as Unconfined for now.
        tasksRepository = DefaultTasksRepository( tasksRemoteDataSource, tasksLocalDataSource, Dispatchers.Unconfined )
    }

    @Test
    fun getTasks_requestAllTasksFromRemoteDataSource() = runTest{
        val tasks = tasksRepository.getTasks(true) as Result.Success
        assertThat(tasks.data, IsEqual(remoteTasks))
    }
}