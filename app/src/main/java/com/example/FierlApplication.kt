package com.example

import android.app.Application
import com.example.data.local.AppDatabase
import com.example.data.repository.FierlRepository

class FierlApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}

class AppContainer(private val application: Application) {
    private val database: AppDatabase by lazy { AppDatabase.getDatabase(application) }
    val fierlRepository: FierlRepository by lazy { FierlRepository(database.fierlDao()) }
}
