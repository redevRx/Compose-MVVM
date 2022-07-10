package com.example.composemvvm

import android.app.Application
import android.os.Bundle
import com.example.composemvvm.core.activity.CoreCompose
import com.example.composemvvm.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(mainModule)
        }
    }
}