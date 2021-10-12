package com.rita.publisher.publish

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        val db = Firebase.firestore

        binding.publishSubmitBtn.setOnClickListener {
            val title = binding.publishTitleEditText.text.toString()
            val category = binding.publishCategoryEditText.text.toString()
            val content = binding.publishContentEditText.text.toString()

            val newArticleRef = db.collection("articles").document()

            val article = Article(
                Author(),
                title,
                content,
                Timestamp(System.currentTimeMillis()),
                newArticleRef.id,
                category
            )

            //Write data
            newArticleRef
                .set(article)
                .addOnSuccessListener { documentReference ->
                    Log.d(
                        ContentValues.TAG,
                        "DocumentSnapshot added with ID: " + newArticleRef.id
                    )
                }
                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error adding document", e); }

            binding.publishTitleEditText.text = null
            binding.publishCategoryEditText.text = null
            binding.publishContentEditText.text = null
        }


        return binding.root
    }


}