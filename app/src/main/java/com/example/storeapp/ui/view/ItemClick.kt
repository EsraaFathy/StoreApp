package com.example.storeapp.ui.view

import com.example.storeapp.model.ProductList


interface ItemClick {
    fun onProductClick(product: ProductList.ProductListItem)
}