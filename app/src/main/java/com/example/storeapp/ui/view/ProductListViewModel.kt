package com.example.storeapp.ui.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.data.remote.Repository
import com.example.storeapp.model.ProductList
import kotlinx.coroutines.launch

class ProductListViewModel(val repository: Repository): ViewModel() {
    private val productsList : MutableLiveData<ProductList> = MutableLiveData()
    fun getProductList() {
        viewModelScope.launch {
            Log.d("data","datadatttttttttttttttt")
            val data=  repository.remoteDataSource.fetchCustomersData()
            Log.d("data","datadataaaaaaaaaaaaaaaaaa")
            if (data!=null)
                productsList.postValue(data)
            Log.d("data","productsList.postValue(data) $data")

        }
    }
    fun getProducts() = productsList
}