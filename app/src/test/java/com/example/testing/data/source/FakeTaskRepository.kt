package com.example.testing.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testing.data.Result
import com.example.testing.data.Task
import kotlinx.coroutines.runBlocking

class FakeTaskRepository : TasksRepository {

    var tasksServiceData: LinkedHashMap<String, Task> = LinkedHashMap()

    private val observableTasks = MutableLiveData<Result<List<Task>>>()
    private val observableTask = MutableLiveData<Result<Task>>()


    override suspend fun getTasks(forceUpdate: Boolean): Result<List<Task>> {
        return Result.Success(tasksServiceData.values.toList())
    }

    override suspend fun refreshTasks() {
        observableTasks.value = getTasks()
    }

    override fun observeTasks(): LiveData<Result<List<Task>>> {
        runBlocking { refreshTasks() }
        return observableTasks
    }

    override suspend fun refreshTask(taskId: String) {
        observableTask.value = getTask(taskId, false)
    }

    override fun observeTask(taskId: String): LiveData<Result<Task>> {
        runBlocking { refreshTask(taskId) }
        return observableTask
    }

    override suspend fun getTask(taskId: String, forceUpdate: Boolean): Result<Task> {
        return tasksServiceData[taskId]?.let {
            Result.Success(it)
        } ?: run { Result.Error(Exception("Task not found")) }
    }

    override suspend fun saveTask(task: Task) {
        addTasks(task)
    }

    override suspend fun completeTask(task: Task) {
        tasksServiceData[task.id]?.isCompleted = true
    }

    override suspend fun completeTask(taskId: String) {
        tasksServiceData[taskId]?.isCompleted = true
    }

    override suspend fun activateTask(task: Task) {
        tasksServiceData[task.id]?.isCompleted = false
    }

    override suspend fun activateTask(taskId: String) {
        tasksServiceData[taskId]?.isCompleted = false
    }

    override suspend fun clearCompletedTasks() {
        val temp = tasksServiceData
        temp.map {
            if (it.value.isCompleted) tasksServiceData.remove(it.key)
        }
    }

    override suspend fun deleteAllTasks() {
        tasksServiceData.clear()
    }

    override suspend fun deleteTask(taskId: String) {
        tasksServiceData.remove(taskId)
    }

    fun addTasks(vararg tasks: Task) {
        for (task in tasks) {
            tasksServiceData[task.id] = task
        }
        runBlocking { refreshTasks() }
    }
}