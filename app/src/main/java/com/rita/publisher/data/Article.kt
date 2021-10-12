package com.rita.publisher.data

import java.sql.Timestamp

data class Article(
    val author: Author?,
    val title:String,
    val content:String,
    val created_time: Timestamp?,
    val id:String?,
    val category:String?,
){constructor() : this(null, "", "",null,"",null){}}
