package com.example.kotlin_lv1_hw3.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin_lv1_hw3.ServiceLocator
import com.example.kotlin_lv1_hw3.datalayer.Server
import com.example.kotlin_lv1_hw3.objects.Article
import com.example.kotlin_lv1_hw3.objects.Profile
import kotlinx.coroutines.flow.Flow

class MainViewModel() : ViewModel() {
    private val dataSource = ServiceLocator.dataSource()

    suspend fun getArticles(): Flow<PagingData<Article>> {
        return dataSource.getArticles().cachedIn(viewModelScope)
    }

    suspend fun getProfile() : Profile {
        val server = Server()
        return server.getProfile()
    }
}