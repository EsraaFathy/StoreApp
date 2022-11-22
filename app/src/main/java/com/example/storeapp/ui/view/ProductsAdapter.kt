package com.example.storeapp.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storeapp.R
import com.example.storeapp.databinding.ProductItemBinding
import com.example.storeapp.model.MovieResponse
import com.example.storeapp.model.ProductList
import com.example.storeapp.model.Search

class ProductsAdapter(private var productList: MovieResponse, private val itemClick: ItemClick) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ProductItemBinding, private val context : Context) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindData(product : Search, itemClick: ItemClick) {
            Glide.with(context)
                .load(product.Poster)
                .into(binding.itemIcon)
            binding.productTitle.text = product.Title
            binding.productPrice.text = "${product.Year} ${context.getString(R.string.eg)}"

            binding.root.setOnClickListener {
                itemClick.onProductClick(product)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding,parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(productList.Search[position],itemClick)
    }

    override fun getItemCount(): Int {
        return productList.Search.size
    }
}