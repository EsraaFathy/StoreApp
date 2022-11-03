package com.example.storeapp.data.remote

import com.example.storeapp.model.ProductList
import com.example.storeapp.network.Network

class RemoteDataSourceImp :RemoteDataSource {

    override suspend fun fetchCustomersData(): ProductList? {

        val response = Network.apiService.getProductsList()
        try {
            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return null
    }

}