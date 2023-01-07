package com.example.kotlin_lv1_hw3.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_lv1_hw3.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContentFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private var articleAdapter = ArticleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }

        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val errorMsg: TextView = view.findViewById(R.id.errorMsg)
        val retryBtn: Button = view.findViewById(R.id.retryButton)
        val loadBtn: Button = view.findViewById(R.id.loadButton)

        retryBtn.isVisible = false
        loadBtn.setOnClickListener {
            loadBtn.isVisible = false
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getArticles().collectLatest { data ->
                    articleAdapter.submitData(data)
                    articleAdapter.loadStateFlow.collectLatest { loadStates ->
                        Log.d("TEST", loadStates.toString())
                        progressBar.isVisible = loadStates.append is LoadState.Loading
                        if ((loadStates.append is LoadState.Error) || (loadStates.refresh is LoadState.Error)) {
                            errorMsg.isVisible = true
                            errorMsg.text = getString(R.string.error)
                            retryBtn.isVisible = true
                        } else {
                            errorMsg.isVisible = false
                            retryBtn.isVisible = false
                        }
                    }
                }
            }
        }

        retryBtn.setOnClickListener{
            viewLifecycleOwner.lifecycleScope.launch {
                articleAdapter.retry()
            }
        }
    }

    companion object {
        fun newInstance() = ContentFragment()
    }
}