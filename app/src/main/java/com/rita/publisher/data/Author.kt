package com.rita.publisher.data

data class Author (
    val id:String="",
    val name:String="",
    val email:String=""
) {
    constructor() : this("waynechen323", "AKA小安老師", "wayne@school.appworks.tw") {}}
