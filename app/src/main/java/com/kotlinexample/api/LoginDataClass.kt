package com.kotlinexample.api

data class RegisterModel(val username: String,
                    val password: String)

data class LoginModel(val username: String,
                 val password: String)

data class UserModel(val success: Boolean,
                val token: String)