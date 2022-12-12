package com.example.storeapp.data.remote

interface RemoteDataSource {
     suspend fun <T> fetchData(path: String, query: String, ofClass: Class<T>): T?
}