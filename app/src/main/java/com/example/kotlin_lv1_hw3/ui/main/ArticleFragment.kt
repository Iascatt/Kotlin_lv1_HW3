package com.example.kotlin_lv1_hw3.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlin_lv1_hw3.R
import com.example.kotlin_lv1_hw3.ServiceLocator
import com.example.kotlin_lv1_hw3.objects.Article
import kotlinx.coroutines.launch
import kotlin.math.round

class ArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image: ImageView by lazy { view.findViewById(R.id.image) }
        val title: TextView by lazy { view.findViewById(R.id.title) }
        val content: TextView by lazy { view.findViewById(R.id.content) }
        val date: TextView by lazy { view.findViewById(R.id.date) }
        val author: TextView by lazy { view.findViewById(R.id.author) }
        val categories: TextView by lazy { view.findViewById(R.id.categories) }
        val article = arguments?.getParcelable<Article>("key")
        if (article != null) {

            val url = article.image
            if (url != "null")
            Glide.with(ServiceLocator.context).load(url).diskCacheStrategy(DiskCacheStrategy.DATA).into(image)



            title.text = article.title
            content.text = article.content
            date.text = article.date
            try {
                author.text = "Author: " + article.author.joinToString(", ")
            } catch (e: Exception) {
                author.text = "Author: no info"
            }

            try {
                categories.text = "Categories: " + article.categories.joinToString(", ")
            } catch (e: Exception) {
                categories.text = "Categories: no info"
            }
        }
    }

    companion object {
        fun newInstance(
            field: Article
        ): ArticleFragment {
            return ArticleFragment().apply {
                arguments = Bundle().apply { putParcelable("key", field) }
            }
        }

    }
}