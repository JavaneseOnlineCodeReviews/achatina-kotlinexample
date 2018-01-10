package com.kotlinexample.presentation.presenter.products


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kotlinexample.api.ApiProductsService.Factory.create
import com.kotlinexample.api.ProductReviewModel
import com.kotlinexample.presentation.view.products.DetailProductView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class DetailProductPresenter : MvpPresenter<DetailProductView>(){
    fun getRatings(id: Long){
        create().getReviews(id).enqueue(object : Callback<List<ProductReviewModel>> {
            override fun onFailure(call: Call<List<ProductReviewModel>>?, t: Throwable?) {
                viewState.errorMessage()
                viewState.endProgress()
            }

            override fun onResponse(call: Call<List<ProductReviewModel>>?, response: Response<List<ProductReviewModel>>?) {
                viewState.initAdapter(response?.body())
                viewState.endProgress()
            }

        })
    }
}
