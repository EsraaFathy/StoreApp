package com.example.storeapp.ui.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.base.BaseViewModel
import com.example.storeapp.model.MovieResponse
import com.example.storeapp.domain.useCase.MovieDataUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
class ProductListViewModel(private val movieDataUseCase: MovieDataUseCase): BaseViewModel() {


    private val productsList : MutableLiveData<MovieResponse> = MutableLiveData()
    private val _errorHandling : MutableLiveData<String> = MutableLiveData()
    val errorHandling : LiveData<String> = _errorHandling

    fun getProductList() : LiveData<MovieResponse> {
        viewModelScope.launch {
            try {
                movieDataUseCase.launch()
                movieDataUseCase.resultFlow.collect{
                    productsList.postValue(it)
                }

            } catch (ce: CancellationException) {
                Log.d("Data",ce.message.toString())
                throw ce // Needed for coroutine scope cancellation
            } catch (e: Exception) {
                _errorHandling.postValue(e.message)
            }

        }
        return productsList
    }
}