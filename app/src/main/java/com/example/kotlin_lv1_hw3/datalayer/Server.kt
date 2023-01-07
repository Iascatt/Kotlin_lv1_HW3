package com.example.kotlin_lv1_hw3.datalayer

import com.example.kotlin_lv1_hw3.objects.Article
import com.example.kotlin_lv1_hw3.objects.Profile
import kotlinx.coroutines.delay
import retrofit2.http.Query
import java.util.ArrayList

class Server {
    suspend fun getProfile() : Profile {
        val profile = Profile()
        delay(5000)
        return profile
    }
}