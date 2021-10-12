package com.rita.publisher.publish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rita.publisher.R
import com.rita.publisher.databinding.FragmentArticlePublishBinding


class ArticlePublishFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //layout binding
        val binding: FragmentArticlePublishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_article_publish, container, false)


        return binding.root
    }


}