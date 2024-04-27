package com.example.taskdive.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskdive.data.room.entities.TagEntity

@Dao
interface TagDao {
    @Query("SELECT * FROM TagEntity")
    suspend fun getAllTags(): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTag(tag: TagEntity)

    @Update
    suspend fun updateTag(tag: TagEntity)

    @Delete
    suspend fun deleteTag(tag: TagEntity)

    @Query("DELETE FROM TagEntity")
    suspend fun deleteAllTags()

    // связанные с задачами

    @Query(
        "SELECT Tag.* " +
                "FROM TagEntity Tag INNER JOIN TaskTagCrossRef CrossRef " +
                "ON Tag.tagId = CrossRef.tagId " +
                "WHERE taskId = :taskId"
    )
    suspend fun getTagsForTask(taskId: Int): List<TagEntity>

}