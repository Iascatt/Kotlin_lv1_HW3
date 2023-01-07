package com.example.kotlin_lv1_hw3.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_lv1_hw3.R
import com.example.kotlin_lv1_hw3.objects.Article

class ArticleAdapter: PagingDataAdapter<Article, ArticleViewHolder>(DiffitemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val gif = getItem(position)
        if (gif != null) {
            holder.bind(gif)
        }
    }

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }
}