package com.example.storeapp.domain.repo

interface Repository {

   suspend fun <T> getData(path: String, query: String, ofClass: Class<T>) : T?
}