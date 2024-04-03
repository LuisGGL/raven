package com.raven.news.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.raven.news.databinding.FragmentNewsDetailBinding
import com.raven.news.presentation.viewmodel.NewDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[NewDetailViewModel::class.java]

        binding.viewModel = viewModel
        return binding.root
    }
}