package com.kotlinexample.presentation.view.products

import com.arellomobile.mvp.MvpView
import com.kotlinexample.api.ProductReviewModel

interface DetailProductView : MvpView{
    fun initAdapter(products: List<ProductReviewModel>?)

    fun errorMessage()

    fun startProgress()

    fun endProgress()
}
