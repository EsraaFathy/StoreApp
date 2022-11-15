package com.example.storeapp.ui.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.data.remote.Repository
import com.example.storeapp.model.ProductList
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductListViewModel(private val repository: Repository): ViewModel() {
    private val productsList : MutableLiveData<ProductList> = MutableLiveData()
    private val errorHandling : MutableLiveData<String> = MutableLiveData()
    fun getProductList() {
        viewModelScope.launch {
            try {
                val data=  repository.remoteDataSource.fetchCustomersData()
                if (data!=null)
                    productsList.postValue(data)

            } catch (ce: CancellationException) {
                Log.d("Data",ce.message.toString())
                throw ce // Needed for coroutine scope cancellation
            } catch (e: Exception) {
                errorHandling.postValue(e.message)
            }

        }
    }
    fun getProducts() = productsList
    fun getError() = errorHandling
}