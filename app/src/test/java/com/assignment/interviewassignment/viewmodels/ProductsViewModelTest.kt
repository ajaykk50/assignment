package com.assignment.interviewassignment.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assignment.interviewassignment.MainCoroutineRule
import com.assignment.interviewassignment.getOrAwaitValueTest
import com.assignment.interviewassignment.repositories.FakeProductsRepository
import com.waheed.nytimes.other.Resource
import com.waheed.nytimes.other.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ProductsViewModel

    @Before
    fun setup() {
        viewModel = ProductsViewModel(FakeProductsRepository())
    }

    @Test
    fun `Get products list, returns success`() {
        viewModel.getProductsList()
        val value = viewModel.productsList.getOrAwaitValueTest()
        assert(value.getContentIfNotHandled()?.data?.size!! > 0)
    }

    @Test
    fun `Get products list, returns empty`() {
        viewModel.getProductsList()
        val value = viewModel.productsList.getOrAwaitValueTest()
        assert(value.getContentIfNotHandled()?.data?.size!! > 0)
    }
}