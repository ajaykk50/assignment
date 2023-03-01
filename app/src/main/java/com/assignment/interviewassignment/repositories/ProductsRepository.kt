package com.assignment.interviewassignment.repositories

import com.assignment.interviewassignment.data.remote.response.productsItem
import com.assignment.interviewassignment.other.Resource

interface ProductsRepository {
    suspend fun getProductslist(): Resource<ArrayList<productsItem>>
}