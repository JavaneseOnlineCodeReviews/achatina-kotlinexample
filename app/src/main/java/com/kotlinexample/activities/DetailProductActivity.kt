package com.kotlinexample.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kotlinexample.R
import com.kotlinexample.adapters.RatingsAdapter
import com.kotlinexample.api.ProductReviewModel
import com.kotlinexample.api.ProductSingleton
import com.kotlinexample.presentation.presenter.products.DetailProductPresenter
import com.kotlinexample.presentation.view.products.DetailProductView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product.*

class DetailProductActivity : MvpActivity(), DetailProductView {

    val singleton = ProductSingleton

    @InjectPresenter
    lateinit var mDetailProductPresenter: DetailProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product)

        Picasso.with(this).load("http://smktesting.herokuapp.com/static/" + singleton.img).into(imageView)
        val title: TextView = findViewById(R.id.title)
        title.text = singleton.title
        val text: TextView = findViewById(R.id.text)
        text.text = singleton.text

        mDetailProductPresenter.getRatings(singleton.id)

    }

    companion object {
        val TAG = "DetailProductActivity"

        fun getIntent(context: Context): Intent {
            return Intent(context, DetailProductActivity::class.java)
        }
    }

    override fun initAdapter(products: List<ProductReviewModel>?) {
        val adapter = RatingsAdapter(products, this)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_rating)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.visibility = VISIBLE
    }

    override fun errorMessage() {
        Toast.makeText(this, "Can't get retings", Toast.LENGTH_SHORT).show()
    }

    override fun startProgress() {
        product_progress.visibility = VISIBLE
    }

    override fun endProgress() {
        product_progress.visibility = INVISIBLE
    }
}
