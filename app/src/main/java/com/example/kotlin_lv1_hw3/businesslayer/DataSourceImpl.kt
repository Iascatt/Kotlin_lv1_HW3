package com.example.kotlin_lv1_hw3.businesslayer

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kotlin_lv1_hw3.datalayer.IAccessor
import com.example.kotlin_lv1_hw3.objects.Article
import kotlinx.coroutines.flow.Flow

class DataSourceImpl (
    private val accessor: IAccessor
)  {
    suspend fun getArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PagingSource(backend = accessor)
            }
        ).flow
    }
}