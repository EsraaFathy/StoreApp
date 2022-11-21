package com.example.storeapp.network


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @GET("{path}")
   suspend fun getProductsList(@Path(value = "path" , encoded = true)  path: String,
                               @Query("s") query: String): Response<ResponseBody>?

}