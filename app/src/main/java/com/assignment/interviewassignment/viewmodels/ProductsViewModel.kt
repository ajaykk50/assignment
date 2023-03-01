package com.assignment.interviewassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.interviewassignment.data.remote.response.productsItem
import com.assignment.interviewassignment.other.Event
import com.assignment.interviewassignment.other.Resource
import com.assignment.interviewassignment.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    val _productsList = MutableLiveData<Event<Resource<ArrayList<productsItem>>>>()
    val productsList: LiveData<Event<Resource<ArrayList<productsItem>>>> = _productsList

    fun getProductsList() {
        viewModelScope.launch {
            val response = repository.getProductslist()
            _productsList.value = Event(response)
        }
    }

}