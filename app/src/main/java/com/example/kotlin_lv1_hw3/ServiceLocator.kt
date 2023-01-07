package com.example.kotlin_lv1_hw3

import android.annotation.SuppressLint
import android.content.Context
import com.example.kotlin_lv1_hw3.businesslayer.DataSourceImpl
import com.example.kotlin_lv1_hw3.datalayer.IAccessor

@SuppressLint("StaticFieldLeak")
object ServiceLocator {
    lateinit var context: Context

    private val accessor by lazy { IAccessor.create()  }

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    fun dataSource(): DataSourceImpl {
        return DataSourceImpl(accessor)
    }
}