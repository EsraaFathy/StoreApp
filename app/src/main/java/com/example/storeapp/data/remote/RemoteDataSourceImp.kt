package com.example.storeapp.data.remote

import android.util.Log
import com.example.storeapp.model.ProductList
import com.example.storeapp.network.Network

class RemoteDataSourceImp :RemoteDataSource {

    override suspend fun fetchCustomersData(): ProductList? {
        Log.d("data","fetchCustomersData")

        val response = Network.apiService.getProductsList()
        try {
            Log.d("data","errordata $response ")

            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("data","errordata ${e.printStackTrace()} ")

        }
        return null
    }

}