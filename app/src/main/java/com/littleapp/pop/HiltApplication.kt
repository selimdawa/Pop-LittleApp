package com.littleapp.pop

import android.app.Application
import com.littleapp.pop.repository.FunkoRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    val repository: FunkoRepository by lazy { FunkoRepository() }

    companion object {
        private lateinit var instance: HiltApplication
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}