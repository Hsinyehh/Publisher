package com.rita.publisher.publish

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rita.publisher.R
import com.rita.publisher.data.Article
import com.rita.publisher.data.Author
import com.rita.publisher.databinding.FragmentArticlePublishBinding
import java.sql.Timestamp


class ArticlePublishFragment : Fragment() {
    private val viewModel:ArticlePublishViewModel by lazy {
        ViewModelProvider(this).get(ArticlePublishViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //layout binding
        val binding: FragmentArticlePublishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_article_publish, container, false)

        binding.viewModel=viewModel
        binding.lifecycleOwner=viewLifecycleOwner

        viewModel.navigateToHome.observe(viewLifecycleOwner, Observer {
            if(it==true){
                view?.findNavController()?.navigate(R.id.navigate_to_home_fragment)
                viewModel.doneNavigated()
            }
        })


        return binding.root
    }


}