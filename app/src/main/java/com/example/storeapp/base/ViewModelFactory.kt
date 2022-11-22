package com.example.storeapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.dataSource.remote.RemoteDataSourceImp
import com.example.storeapp.dataSource.RepositoryImp
import com.example.storeapp.ui.view.ProductListViewModel
import com.example.storeapp.useCase.MovieDataUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            val movieDataUseCase = MovieDataUseCase(
                RepositoryImp(
                RemoteDataSourceImp(),
            )
            )
            return ProductListViewModel(movieDataUseCase) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}