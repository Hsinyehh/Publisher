package com.rita.publisher.publish

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ArticlePublishViewModel:ViewModel() {

    val db = Firebase.firestore


}