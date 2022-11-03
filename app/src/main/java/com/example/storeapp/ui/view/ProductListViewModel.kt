package com.example.storeapp.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.data.remote.Repository
import com.example.storeapp.model.ProductList
import kotlinx.coroutines.launch

class ProductListViewModel(private val repository: Repository): ViewModel() {
    private val productsList : MutableLiveData<ProductList> = MutableLiveData()
    fun getProductList() {
        viewModelScope.launch {
            val data=  repository.remoteDataSource.fetchCustomersData()
            if (data!=null)
                productsList.postValue(data)

        }
    }
    fun getProducts() = productsList
}