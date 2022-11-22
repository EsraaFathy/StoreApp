package com.example.storeapp.dataSource.remote

interface RemoteDataSource {
     suspend fun <T> fetchData(path: String, query: String, ofClass: Class<T>): T?
}