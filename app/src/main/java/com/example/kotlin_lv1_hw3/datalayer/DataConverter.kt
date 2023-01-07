package com.example.kotlin_lv1_hw3.datalayer

import android.util.Log
import com.example.kotlin_lv1_hw3.objects.Data
import okhttp3.ResponseBody
import retrofit2.Converter

class DataConverter<Any>(
    private val delegate: Converter<ResponseBody, Data<Any>>?
) : Converter<ResponseBody, Any> {
    override fun convert(value: ResponseBody): Any? {
        val graphQLDataModel = delegate?.convert(value)
        return graphQLDataModel?.data
    }
}