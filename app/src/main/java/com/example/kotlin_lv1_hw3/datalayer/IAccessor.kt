package com.example.kotlin_lv1_hw3.datalayer

import android.util.Log
import com.example.kotlin_lv1_hw3.objects.Article
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IAccessor {
    @GET("api/1/news?apikey=pub_1538457bb9b18cc2e2ac3e7516c89d7a27ce0&q=fitness&language=en")
    suspend fun getArticles() : List<Article>

    companion object {
        fun create(): IAccessor {

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().apply {
                addNetworkInterceptor(loggingInterceptor)
            }.build()

            val retrofit = Retrofit.Builder().apply {
                client(client)
                addConverterFactory(DataConverterFactory())
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://newsdata.io/")
            }.build()

            return retrofit.create(IAccessor::class.java)
        }
    }
}
