package com.kotlinexample.presentation.view.login

import com.arellomobile.mvp.MvpView
import com.kotlinexample.api.UserModel

interface LoginView : MvpView {
    fun login(userModel: UserModel?)
}
