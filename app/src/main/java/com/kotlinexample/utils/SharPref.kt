package com.kotlinexample.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharPref(context: Context){
    private val preference:SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    val token:String get() = preference.getString("token", "")

    fun putToken(token:String){
        preference.edit().putString("token", token).apply()
    }
}