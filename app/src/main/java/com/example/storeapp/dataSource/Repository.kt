package com.example.storeapp.dataSource

import com.example.storeapp.dataSource.remote.RemoteDataSource

interface Repository {
    val remoteDataSource: RemoteDataSource

   suspend fun <T: Any> getData(path: String, query: String, ofClass: Class<T>) : T?
}