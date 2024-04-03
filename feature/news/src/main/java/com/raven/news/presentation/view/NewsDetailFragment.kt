package com.raven.news.presentation.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.raven.core.bases.NavigationListener
import com.raven.core.bases.util.NewsHelper
import com.raven.news.databinding.FragmentNewsDetailBinding
import com.raven.news.presentation.viewmodel.NewDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    private lateinit var viewModel: NewDetailViewModel
    lateinit var listener: NavigationListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationListener) {
            listener = context
        } else {
            throw IllegalArgumentException("Context must implement NavigationListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[NewDetailViewModel::class.java]

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNewTitle.text = NewsHelper.title
        binding.tvAuthor.text = NewsHelper.author
        binding.tvDate.text = NewsHelper.date
        binding.tvSection.text = NewsHelper.section
        binding.tvSection.text = NewsHelper.section
        binding.tvNew.text = NewsHelper.resume

        Glide.with(this)
            .load(NewsHelper.image)
            .apply(RequestOptions().centerCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.ivNew)

        binding.btnBack.setOnClickListener {
            listener.goBack()
        }

        binding.btnMore.setOnClickListener {
            val url = NewsHelper.newsUrl
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}