package com.kotlinexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kotlinexample.R
import com.kotlinexample.api.LoginModel
import com.kotlinexample.api.RegisterModel
import com.kotlinexample.api.UserModel
import com.kotlinexample.presentation.presenter.login.LoginPresenter
import com.kotlinexample.presentation.view.login.LoginView
import com.kotlinexample.utils.SharPref
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : MvpFragment(), LoginView {

    @InjectPresenter
    lateinit var mLoginPresenter: LoginPresenter

    override fun login(userModel: UserModel?) {
        if (userModel!!.success){
            SharPref(activity).putToken(userModel.token)
            fragmentManager.beginTransaction().replace(R.id.fragment, ProdListFragment()).commit()
        } else {
            Toast.makeText(activity, "Fail", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                     savedInstanceState: Bundle?): View = inflater.inflate(R.layout.login_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register.setOnClickListener { mLoginPresenter.register(RegisterModel(username.text.toString(), password.text.toString())) }

        login.setOnClickListener { mLoginPresenter.login(LoginModel(username.text.toString(), password.text.toString())) }

        no_login.setOnClickListener { fragmentManager.beginTransaction().replace(R.id.fragment, ProdListFragment()).commit() }
    }

    companion object {
        val TAG = "LoginFragment"

        fun newInstance(): LoginFragment {
            val fragment = LoginFragment()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }
}
