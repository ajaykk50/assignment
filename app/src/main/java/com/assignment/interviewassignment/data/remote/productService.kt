package com.assignment.interviewassignment.data.remote

import com.assignment.interviewassignment.data.remote.response.products
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface productService {

    @GET("photos")
    suspend fun getProducts(): Response<products>

}