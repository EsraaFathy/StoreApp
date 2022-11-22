package com.example.storeapp.dataSource.remote

import com.example.storeapp.network.Network
import com.google.gson.Gson


class RemoteDataSourceImp :RemoteDataSource {

    override suspend fun <T> fetchData(path: String, query: String, ofClass: Class<T>): T? {

        val responseCall = Network.apiService.getProductsList(path,query)
        try {
            if (responseCall != null) {
                if (responseCall.isSuccessful) {
                    val gson = Gson()
                    return gson.fromJson(responseCall.body()?.string() ?: "error:error", ofClass)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return null
    }

}