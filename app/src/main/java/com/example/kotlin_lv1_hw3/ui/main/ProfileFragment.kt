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
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.kotlin_lv1_hw3.R
import com.example.kotlin_lv1_hw3.datalayer.Server
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.round
import kotlin.math.roundToLong


class ProfileFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val avatar = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.name)
        val weight = view.findViewById<TextView>(R.id.weight)
        val height = view.findViewById<TextView>(R.id.height)
        val bmi = view.findViewById<TextView>(R.id.bmi)
        val bar = view.findViewById<ProgressBar>(R.id.progressBar2)
        viewLifecycleOwner.lifecycleScope.launch {
            val profile = viewModel.getProfile()
            avatar.setImageDrawable(resources.getDrawable(profile.avatar))
            name.text = "Name: " + profile.name
            weight.text = "Weight: " + profile.weight.toString()
            height.text = "Height: " + profile.height.toString()
            bmi.text = "BMI: " +
                    (round(profile.weight / profile.height / profile.height * 100)
                            / 100).toString()
            bar.isVisible = false
        }
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}