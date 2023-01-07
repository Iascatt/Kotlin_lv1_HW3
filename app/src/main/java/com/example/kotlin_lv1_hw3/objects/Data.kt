package com.example.kotlin_lv1_hw3.objects

import com.google.gson.annotations.SerializedName

class Data<T> {
    @SerializedName("results")
    var data: T? = null
}