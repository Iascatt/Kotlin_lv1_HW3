package com.example.kotlin_lv1_hw3.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlin_lv1_hw3.objects.Article

class DiffitemCallback: DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }
}