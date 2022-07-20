package com.example.pocofdigivalapp.application

import android.app.Application
import com.example.pocofdigivalapp.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class CourseListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configKoin()
    }

    private fun configKoin() {
        startKoin {
            androidLogger(org.koin.core.logger.Level.NONE)
            androidContext(this@CourseListApplication)
            modules(AppModule.appModules())
        }
    }
}

