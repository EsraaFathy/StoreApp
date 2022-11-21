package com.example.storeapp.data.remote

import android.util.Log
import com.example.storeapp.model.MovieResponse
import com.example.storeapp.model.ProductList
import com.example.storeapp.network.Network
import com.google.gson.Gson
import org.json.JSONObject


class RemoteDataSourceImp :RemoteDataSource {

    override suspend fun fetchData(clazz: Class<*>?): Any? {

        val responseCall = Network.apiService.getProductsList("api","batman")
        try {
            if (responseCall != null) {
                if (responseCall.isSuccessful) {
                    val gson = Gson()
                    val responseObject: Any = gson.fromJson(responseCall.body()?.string() ?: "error:error", clazz)
                   val movie = responseObject as MovieResponse
                    Log.d("response data = ... ", movie.Search[1].Poster ?: "errorrrrr")
                    val jsonobject = JSONObject(responseCall.body()?.string() ?: "errorrrrr")
                    return ProductList()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return null
    }

}