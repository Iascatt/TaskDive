package com.example.taskdive.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskdive.data.room.entities.TaskEntity

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: TaskEntity)

    @Query("SELECT * FROM TaskEntity")
    suspend fun getAllTasks(): List<TaskEntity>

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("DELETE FROM TaskEntity")
    suspend fun deleteAllTasks()

    // фильтрация
    /*
    @Query("SELECT Task.* " +
            "FROM TaskEntity Task INNER JOIN TaskTagCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.taskId " +
            "WHERE tagId = :tagId " +
            "ORDER BY importance")
    suspend fun getFilteredTasksSortByImportance(
        searchText: String,
        tagId: Int
    ): List<TaskEntity>

    @Query("SELECT Task.* " +
            "FROM TaskEntity Task INNER JOIN TaskTagCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.taskId " +
            "WHERE tagId = :tagId " +
            "ORDER BY fin_date")
    suspend fun getFilteredTasksSortByUrgency(
        searchText: String,
        tagId: Int
    ): List<TaskEntity>


    @Query("SELECT Task.* " +
            "FROM TaskEntity Task INNER JOIN TaskTagCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.taskId " +
            "WHERE tagId = :tagId " +
            "ORDER BY difficulty")
    suspend fun getFilteredTasksSortByDifficulty(
        searchText: String,
        tagId: Int
    ): List<TaskEntity>
*/
    // вложенность
    @Query("SELECT Task.* " +
            "FROM TaskEntity Task INNER JOIN SupertaskSubtaskCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.supertaskId " +
            "WHERE subtaskId = :taskId")
    suspend fun getSubtasksForTask(taskId: Int): List<TaskEntity>

    @Query("SELECT COUNT(*) " +
            "FROM TaskEntity Task INNER JOIN SupertaskSubtaskCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.supertaskId " +
            "WHERE subtaskId = :taskId")
    suspend fun countSubtasksForTask(taskId: Int): Int

    @Query("SELECT Task.* " +
            "FROM TaskEntity Task INNER JOIN SupertaskSubtaskCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.subtaskId " +
            "WHERE supertaskId = :taskId")
    suspend fun getSupertasksForTask(taskId: Int): List<TaskEntity>

    @Query("SELECT COUNT(*) " +
            "FROM TaskEntity Task INNER JOIN SupertaskSubtaskCrossRef CrossRef " +
            "ON Task.taskId = CrossRef.subtaskId " +
            "WHERE supertaskId = :taskId")
    suspend fun countSupertasksForTask(taskId: Int): Int
}