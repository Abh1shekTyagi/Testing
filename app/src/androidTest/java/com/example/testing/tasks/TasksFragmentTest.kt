package com.example.testing.tasks

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.testing.R
import com.example.testing.data.Task
import com.example.testing.taskdetail.TaskDetailFragment
import com.example.testing.taskdetail.TaskDetailFragmentArgs
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@MediumTest
class TasksFragmentTest {


    @Test
    fun activeTaskDetails_DisplayedInUi() {
        val task = Task(
            "Watch Replacement",
            "Watch is broken have to replace it before june",
            isCompleted = false
        )

        val bundle = TaskDetailFragmentArgs(task.id).toBundle()
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)
        Thread.sleep(2000)
    }
}