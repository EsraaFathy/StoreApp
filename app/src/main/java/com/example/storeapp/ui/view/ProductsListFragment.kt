package com.example.storeapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.base.ViewModelFactory
import com.example.storeapp.data.remote.RemoteDataSourceImp
import com.example.storeapp.data.remote.RepositoryImp
import com.example.storeapp.databinding.FragmentProductsListBinding


class ProductsListFragment : BaseFragment() {
    private lateinit var binding: FragmentProductsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProductsListBinding.inflate(inflater, container, false)
        val repository = RepositoryImp(
            RemoteDataSourceImp(),
        )
        val viewModelFactory = ViewModelFactory(repository)
       val productViewModel = ViewModelProvider(requireActivity(),viewModelFactory)[ProductListViewModel::class.java]

        productViewModel.getProductList()

        productViewModel.getProducts().observe(viewLifecycleOwner,{
            Log.d("data", it.toString())

        })
        return binding.root
    }

}