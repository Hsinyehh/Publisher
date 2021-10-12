package com.rita.publisher.data

import java.sql.Timestamp
import java.util.*

data class Article(
    val author: Author?,
    val title:String,
    val content:String,
    val created_time: Long?,
    val id:String?,
    val category:String?,
){constructor() : this(null, "", "",null,"",null){}}
