package com.kotlinexample.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlinexample.R
import com.kotlinexample.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().replace(R.id.fragment, LoginFragment()).commit()
    }
}