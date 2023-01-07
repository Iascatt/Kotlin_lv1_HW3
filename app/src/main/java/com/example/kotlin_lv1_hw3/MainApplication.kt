package com.example.kotlin_lv1_hw3

import android.app.Application


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.initialize(this)
    }
}