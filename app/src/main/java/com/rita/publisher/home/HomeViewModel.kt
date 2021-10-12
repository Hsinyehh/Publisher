package com.rita.publisher.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rita.publisher.data.Article

class HomeViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<Article>>()

    private val _articleList = MutableLiveData<List<Article>>()

    val articleList: LiveData<List<Article>>
        get() = _articleList


    val db = Firebase.firestore

    init {
        _articleList.value=null
        getArticles()
    }


    private fun getArticles(){

        val list= mutableListOf<Article>()

        db.collection("articles")
            .orderBy("createdTime", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Rita", "${document.id} => ${document.data}")
                    val article= document.toObject(Article::class.java)
                    list.add(article)
                }
                _articleList.value=list
                Log.i("Rita","homeViewModel._articleList: $_articleList")
            }
            .addOnFailureListener { exception ->
                Log.w("Rita", "Error getting documents.", exception)
            }
    }
}