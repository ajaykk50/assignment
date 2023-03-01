package com.assignment.interviewassignment.di

import android.content.Context
import com.assignment.interviewassignment.BuildConfig
import com.assignment.interviewassignment.R
import com.assignment.interviewassignment.data.remote.productService
import com.assignment.interviewassignment.repositories.ProductsRepository
import com.assignment.interviewassignment.repositories.ProductsRepositoryImpl
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDefaultArticlesRepository(api: productService) =
        ProductsRepositoryImpl(api) as ProductsRepository

//    @Singleton
//    @Provides
//    fun providePiccassoInstance(
//        @ApplicationContext context: Context
//    ) = Picasso.get().load().error(R.drawable.ic_image)


    @Singleton
    @Provides
    fun provideNytApi(): productService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(productService::class.java)
    }
}

















