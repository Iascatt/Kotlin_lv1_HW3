package com.example.kotlin_lv1_hw3.ui.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlin_lv1_hw3.R
import com.example.kotlin_lv1_hw3.ServiceLocator.context
import com.example.kotlin_lv1_hw3.objects.Article

class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image: ImageView by lazy { view.findViewById<ImageView>(R.id.image) }
    private val title: TextView by lazy { view.findViewById<TextView>(R.id.title) }
    private val description: TextView by lazy { view.findViewById<TextView>(R.id.annotation) }
    private val date: TextView by lazy { view.findViewById<TextView>(R.id.date) }
    private val author: TextView by lazy { view.findViewById<TextView>(R.id.author) }
    private val categories: TextView by lazy { view.findViewById<TextView>(R.id.categories) }
    private val view = view

    fun bind(element: Article) {
        val url = element.image
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.DATA).into(image)

        title.text = element.title
        description.text = element.description
        date.text = element.date
        try {
            author.text = "Author: " + element.author.joinToString(", ")
        } catch (e: Exception) {
            author.text = "Author: no info"
        }
        view.setOnClickListener {
            val trasaction = view.findFragment<Fragment>().activity?.supportFragmentManager?.beginTransaction()
            if (trasaction != null) {
                trasaction.replace(R.id.container, ArticleFragment.newInstance(element))
                trasaction.addToBackStack(null)
                trasaction.commit()
            }
        }
    }
}