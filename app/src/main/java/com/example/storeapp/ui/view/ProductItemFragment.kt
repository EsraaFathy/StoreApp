package com.example.storeapp.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.storeapp.R
import com.example.storeapp.base.BaseActivity
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.base.Utils
import com.example.storeapp.databinding.FragmentProductItemBinding
import com.example.storeapp.model.ProductList

class ProductItemFragment : BaseFragment() {

    private lateinit var binding: FragmentProductItemBinding
    private var product: ProductList.ProductListItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).currentFragment = this

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductItemBinding.inflate(inflater, container, false)

        product = arguments?.getSerializable(Utils.productListItem) as ProductList.ProductListItem

        product?.let {
            initView(it)
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initView(itemList: ProductList.ProductListItem) {
        Glide.with(requireActivity())
            .load(itemList.image)
            .into(binding.itemIcon)
        binding.productTitle.text = itemList.title
        binding.productPrice.text = "${itemList.price} ${getString(R.string.eg)}"
        binding.productDescription.text = itemList.description
        binding.ratingBar.rating = itemList.rating?.rate?.toFloat() ?: 0.0f
        binding.ratingCount.text = itemList.rating?.count.toString()
    }

}