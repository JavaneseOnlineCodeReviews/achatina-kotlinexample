package com.kotlinexample.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiLoginService {

    @POST("/api/register/")
    fun register(@Body registerModel: RegisterModel) : Call<UserModel>

    @POST("/api/login/")
    fun login(@Body loginModel: LoginModel) : Call<UserModel>

    companion object Factory{
        fun create(): ApiLoginService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://smktesting.herokuapp.com")
                    .build()
            return retrofit.create(ApiLoginService::class.java)
        }
    }
}