package com.kotlinexample.presentation.view.products

import com.arellomobile.mvp.MvpView
import com.kotlinexample.api.ProductInfoModel

interface ProdListView : MvpView{

    fun initAdapter(products: List<ProductInfoModel>)

    fun errorMessage()

    fun startProgress()

    fun endProgress()
}
