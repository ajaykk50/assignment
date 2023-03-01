package com.assignment.interviewassignment.repositories

import com.assignment.interviewassignment.data.remote.productService
import com.assignment.interviewassignment.data.remote.response.products
import com.assignment.interviewassignment.other.Constants
import com.assignment.interviewassignment.other.Constants.SOMETHING_WENT_WRONG
import com.assignment.interviewassignment.other.Resource
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productService: productService) :
    ProductsRepository {

    override suspend fun getProductslist(): Resource<products> {
        return try {
            val response = productService.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Resource.success(it)
                } ?: Resource.error(SOMETHING_WENT_WRONG, null)
            } else {
                Resource.error(SOMETHING_WENT_WRONG, null)
            }
        } catch (e: java.lang.Exception) {
            Resource.error(Constants.NO_INTERNET, null)
        }
    }
}