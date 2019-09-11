package com.example.jeonghyun.kotlinmvvmsample

import android.app.Application
import com.example.jeonghyun.kotlinmvvmsample.di.DiModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, DiModule) // 의존성 주입 시작
    }
}
