package com.rita.publisher.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rita.publisher.R
import com.rita.publisher.databinding.FragmentHomeBinding
import com.rita.publisher.publish.ArticlePublishViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //layout binding
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        binding.viewModel=viewModel
        binding.lifecycleOwner=viewLifecycleOwner

        //Recyclerview
        val adapter=HomeAdapter()
        binding.articleList.adapter=adapter

        viewModel.articleList.observe(viewLifecycleOwner, Observer {
            Log.i("Rita","articleList observe: ${viewModel.articleList.value}")
            adapter.submitList(it)
        })


        binding.floatingAddButton.setOnClickListener {
            it?.let{
                view?.findNavController()?.navigate(R.id.navigate_to_article_publish_fragment)
            }
        }




        return binding.root
    }


}