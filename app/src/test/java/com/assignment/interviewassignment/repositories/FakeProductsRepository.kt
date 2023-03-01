package com.assignment.interviewassignment.repositories

import com.assignment.interviewassignment.data.remote.response.products
import com.assignment.interviewassignment.data.remote.response.productsItem
import com.waheed.nytimes.other.Resource
import javax.inject.Inject

class FakeProductsRepository @Inject constructor() : ProductsRepository {
    val datalist = ArrayList<productsItem>()

    init {
        datalist.add(productsItem(1, 2, "", "", ""))
        datalist.add(productsItem(1, 2, "", "", ""))
        datalist.add(productsItem(1, 2, "", "", ""))
    }

    override suspend fun getProductslist(): Resource<ArrayList<productsItem>> {
        val response = ArrayList<productsItem>()
        return Resource.success(datalist)
    }

}