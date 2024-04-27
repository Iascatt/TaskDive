package com.example.taskdive.di

import androidx.room.Room
import com.example.taskdive.data.repository.DiveRepository
import com.example.taskdive.data.repository.DiveRepositoryImpl
import com.example.taskdive.data.room.database.DiveDatabase
import com.example.taskdive.data.store.DiveStore
import com.example.taskdive.data.store.DiveStoreImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<DiveDatabase> {
        Room.databaseBuilder(
            androidContext(),
            DiveDatabase::class.java, "dive-db"
        ).build()
    }
    single<DiveStore> { DiveStoreImpl(get()) }
    single<DiveRepository> { DiveRepositoryImpl(get()) }
}