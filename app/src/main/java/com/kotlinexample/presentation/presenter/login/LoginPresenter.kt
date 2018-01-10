package com.kotlinexample.presentation.presenter.login


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlinexample.api.ApiLoginService.Factory.create
import com.kotlinexample.api.LoginModel
import com.kotlinexample.api.RegisterModel
import com.kotlinexample.api.UserModel
import com.kotlinexample.presentation.view.login.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>(){
    fun login(loginModel: LoginModel) {
        create().login(loginModel).enqueue(object : retrofit2.Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                viewState.login(response?.body())
            }

            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
            }

        })
    }

    fun register(registerModel: RegisterModel) {
        create().register(registerModel).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                viewState.login(response?.body())
            }


        })
    }
}
