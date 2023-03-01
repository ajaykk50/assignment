package com.assignment.interviewassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.interviewassignment.R
import com.assignment.interviewassignment.adapter.ProductsAdapter
import com.assignment.interviewassignment.databinding.FragmentProductsBinding
import com.assignment.interviewassignment.other.Status
import com.assignment.interviewassignment.viewmodels.ProductsViewModelNew
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var adapter: ProductsAdapter
    private lateinit var _binding: FragmentProductsBinding
    private val productsviewmmodel: ProductsViewModelNew by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    private fun initRecyclerView() {
        _binding.rvProducts.layoutManager = GridLayoutManager(requireActivity(), 2)
        adapter = ProductsAdapter() {

            val bundle = bundleOf("image" to it.url, "title" to it.title)
            findNavController().navigate(R.id.productDetailsFragment, bundle)
        }
        _binding.rvProducts.adapter = adapter
        displayProducts()
    }

    private fun displayProducts() {
        _binding.pgProgress.visibility = View.VISIBLE
        productsviewmmodel.getProductsList1()
        productsviewmmodel.productsList.observe(viewLifecycleOwner, Observer {
            it?.getContentIfNotHandled()?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        _binding.pgProgress.visibility = View.GONE
                        it.data?.let { it1 -> adapter.setList(it1) }
                        adapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        _binding.pgProgress.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        _binding.pgProgress.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }
}