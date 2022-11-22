package com.example.storeapp.ui.view

import com.example.storeapp.model.ProductList
import com.example.storeapp.model.Search


interface ItemClick {
    fun onProductClick(product: Search)
}