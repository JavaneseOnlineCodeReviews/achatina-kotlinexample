package com.kotlinexample.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProductsService {

    @GET("api/products")
    fun getProducts() : Call<List<ProductInfoModel>>

    @GET("api/reviews/{productId}")
    fun getReviews(@Path("productId") productId : Long) : Call<List<ProductReviewModel>>

    companion object Factory{
        fun create(): ApiProductsService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://smktesting.herokuapp.com")
                    .build()
            return retrofit.create(ApiProductsService::class.java)
        }
    }
}