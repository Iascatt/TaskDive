package com.example.taskdive.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.taskdive.data.room.converters.DiveConverters
import com.example.taskdive.data.room.dao.TagDao
import com.example.taskdive.data.room.dao.TaskDao
import com.example.taskdive.data.room.entities.SupertaskSubtaskCrossRef
import com.example.taskdive.data.room.entities.TagEntity
import com.example.taskdive.data.room.entities.TaskEntity
import com.example.taskdive.data.room.entities.TaskTagCrossRef

@Database(
    entities = [
        TagEntity::class,
        TaskEntity::class,
        TaskTagCrossRef::class,
        SupertaskSubtaskCrossRef::class
               ],
    version = 1
)
@TypeConverters(DiveConverters::class)
abstract class DiveDatabase : RoomDatabase() {
    abstract val tags: TagDao
    abstract val tasks: TaskDao

}