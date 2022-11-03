package com.example.storeapp.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storeapp.R
import com.example.storeapp.databinding.ProductItemBinding
import com.example.storeapp.model.ProductList

class ProductsAdapter(var productList: ProductList,val itemClick: ItemClick) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProductItemBinding,val context : Context) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(product : ProductList.ProductListItem, itemClick: ItemClick) {
            Glide.with(context)
                .load(product.image)
                .into(binding.itemIcon)
            binding.productTitle.text = product.title
            binding.productPrice.text = "${product.price} ${context.getString(R.string.eg)}"

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
        holder.bindData(productList[position],itemClick)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}