package com.example.storeapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit




object Network {
    private const val BASE_URL ="https://fake-movie-database-api.herokuapp.com/"
//    private const val BASE_URL ="https://fakestoreapi.com/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildAuthClient())
            .build()
    }

    val apiService: NetworkService = getRetrofit().create(NetworkService::class.java)

    private fun buildAuthClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(newRequest)
        }

        httpClient.connectTimeout(7000, TimeUnit.SECONDS)
        httpClient.readTimeout(7000, TimeUnit.SECONDS)
        httpClient.writeTimeout(7000, TimeUnit.SECONDS)
        return httpClient.build()
    }
}

