package com.example.storeapp.model

import java.io.Serializable

data class Search(
    val Poster: String,
    var Title: String,
    val Year: String,
    val imdbID: String
): Serializable