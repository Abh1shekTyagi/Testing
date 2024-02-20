package com.example.testing.statistics

import com.example.testing.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf(
            Task("test", "description", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(result.activeTasksPercent, 100f)
        assertEquals( result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_halfComplete_returnsFortySixty() {
        val tasks = listOf(
            Task("test", "description", isCompleted = true),
            Task("test", "description", isCompleted = true),
            Task("test", "description", isCompleted = false),
            Task("test", "description", isCompleted = false),
            Task("test", "description", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(result.activeTasksPercent, 60f)
        assertEquals( result.completedTasksPercent, 40f)
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeroZero() {
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals( result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeroZero() {
        val tasks = emptyList<Task>()
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals( result.completedTasksPercent, 0f)
    }

}