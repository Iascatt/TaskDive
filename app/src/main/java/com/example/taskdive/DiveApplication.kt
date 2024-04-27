package com.example.taskdive

import android.app.Application
import com.example.taskdive.di.managementModule
import com.example.taskdive.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class DiveApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@DiveApplication)
            // modules(dataModule)
            modules(managementModule)
            modules(viewModelModule)
        }
    }
}