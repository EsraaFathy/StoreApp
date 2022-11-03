package com.example.storeapp.data.remote

import com.example.storeapp.model.ProductList

interface RemoteDataSource {
     suspend fun fetchCustomersData(): ProductList?
}