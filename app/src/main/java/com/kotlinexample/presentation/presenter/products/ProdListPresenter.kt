package com.kotlinexample.presentation.presenter.products

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlinexample.api.ApiProductsService.Factory.create
import com.kotlinexample.api.ProductInfoModel
import com.kotlinexample.presentation.view.products.ProdListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class ProdListPresenter : MvpPresenter<ProdListView>(){

    fun getProduts(){
        create().getProducts().enqueue(object : Callback<List<ProductInfoModel>> {
            override fun onFailure(call: Call<List<ProductInfoModel>>?, t: Throwable?) {
                viewState.errorMessage()
                viewState.endProgress()
            }

            override fun onResponse(call: Call<List<ProductInfoModel>>?, response: Response<List<ProductInfoModel>>?) {
                if (response != null)
                    viewState.initAdapter(response.body()!!)
                viewState.endProgress()
            }

        })
    }
}