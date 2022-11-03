package com.example.storeapp.network

import com.example.storeapp.model.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {
    @GET("products")
   suspend fun getProductsList(): Response<ProductList>

}