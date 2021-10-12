package com.rita.publisher

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.rita.publisher.data.Article

@BindingAdapter("title")
fun TextView.bindTitle(item: Article) {
    item?.let{
        text="${it.title}"
    }
}

@BindingAdapter("name")
fun TextView.bindName(item: Article) {
    item?.let{
        text="${it.author?.name}"
    }
}

@BindingAdapter("category")
fun TextView.bindCategory(item: Article) {
    item?.let{
        text="${it.category}"
    }
}

@BindingAdapter("content")
fun TextView.bindContent(item: Article) {
    item?.let{
        text="${it.content}"
    }
}