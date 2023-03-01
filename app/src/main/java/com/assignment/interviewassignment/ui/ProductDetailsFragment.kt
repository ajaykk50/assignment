package com.assignment.interviewassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.interviewassignment.R
import com.assignment.interviewassignment.data.remote.response.productsItem
import com.assignment.interviewassignment.databinding.FragmentProductDetailsBinding
import com.squareup.picasso.Picasso


class ProductDetailsFragment : Fragment() {

    private lateinit var _binding: FragmentProductDetailsBinding
    private var title: String? = ""
    private var image: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        image = arguments?.getString("image")
        title = arguments?.getString("title")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(image).into(_binding.ivImage)
        _binding.tvTitle.text = title
    }

    companion object {}
}