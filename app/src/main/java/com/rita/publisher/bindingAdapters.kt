package com.rita.publisher

import android.os.Build
import android.text.format.DateFormat
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.rita.publisher.data.Article
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

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

@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("time")
fun TextView.bindTime(item: Article) {
    item.created_time?.let{


        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd hh:mm",  Locale.TAIWAN)

        val time=simpleDateFormat.format(Date(it))

        text= time?:null
    }
}


