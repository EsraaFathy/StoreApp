package com.example.storeapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.base.ViewModelFactory
import com.example.storeapp.databinding.FragmentProductsListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storeapp.R
import com.example.storeapp.base.BaseActivity
import com.example.storeapp.model.MovieResponse
import com.example.storeapp.model.Search


class ProductsListFragment : BaseFragment(),ItemClick {
    private lateinit var binding: FragmentProductsListBinding
    private var list: MovieResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).currentFragment = this

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProductsListBinding.inflate(inflater, container, false)

        val viewModelFactory = ViewModelFactory()

       val productViewModel = ViewModelProvider(requireActivity(),viewModelFactory)[ProductListViewModel::class.java]
        binding.productsListRv.visibility = View.INVISIBLE

        if (list==null)
        productViewModel.getProductList().observe(viewLifecycleOwner) {
            if (it != null) {
                list = it
                initRecyclerView(it)
            }

        }


        productViewModel.errorHandling.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(),getString(R.string.an_error_accurate),Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    private fun initRecyclerView(list: MovieResponse) {
        binding.productsListRv.apply {
            binding.shimmerFrameLayout.stopShimmerAnimation()
            binding.shimmerFrameLayout.visibility = View.GONE
            binding.productsListRv.visibility = View.VISIBLE
            this.adapter = ProductsAdapter(list,this@ProductsListFragment)
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onProductClick(product: Search) {
//        val activity = activity as BaseActivity
//        val bundle = Bundle()
//        bundle.putSerializable(Utils.productListItem,product)
//        val fragment = ProductItemFragment()
//        fragment.arguments = bundle
//        activity.replaceFragment(fragment)
    }

}