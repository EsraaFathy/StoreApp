package com.example.storeapp.model

class ProductList : ArrayList<ProductList.ProductListItem>(){
    data class ProductListItem(
        val category: String?,
        val description: String?,
        val id: Int?,
        val image: String?,
        val price: Double?,
        val rating: Rating?,
        val title: String?
    ) {
        data class Rating(
            val count: Int?,
            val rate: Double?
        )
    }
}