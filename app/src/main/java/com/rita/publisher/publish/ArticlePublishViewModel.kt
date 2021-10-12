package com.rita.publisher.publish

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rita.publisher.data.Article
import com.rita.publisher.data.Author
import java.sql.Timestamp
import java.util.*

class ArticlePublishViewModel:ViewModel() {

    val title = MutableLiveData<String>()
    val category = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    val navigateToHome = MutableLiveData<Boolean>()
    val db = Firebase.firestore

    init {
        title.value=null
        category.value=null
        content.value=null
        navigateToHome.value=null
    }

    fun submitArticle(){

        val newArticleRef = db.collection("articles").document()

        val article = Article(
            Author(),
            title.value!!,
            content.value!!,
            //Timestamp(System.currentTimeMillis()),
            Calendar.getInstance().timeInMillis,
            newArticleRef.id,
            category.value!!
        )

        //Write data
        newArticleRef
            .set(article)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    ContentValues.TAG,
                    "DocumentSnapshot added with ID: " + newArticleRef.id
                )

                navigateToHome.value=true
            }
            .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error adding document", e); }

    }


    fun doneNavigated(){
        navigateToHome.value=null
    }


}