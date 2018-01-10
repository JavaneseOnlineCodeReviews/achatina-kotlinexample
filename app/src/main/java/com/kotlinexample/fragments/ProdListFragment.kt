package com.kotlinexample.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kotlinexample.R
import com.kotlinexample.adapters.ProductsAdapter
import com.kotlinexample.api.ProductInfoModel
import com.kotlinexample.presentation.presenter.products.ProdListPresenter
import com.kotlinexample.presentation.view.products.ProdListView
import kotlinx.android.synthetic.main.goods_fragment.*

class ProdListFragment : MvpFragment(), ProdListView {
    override fun startProgress() {
        progressBar.visibility = VISIBLE
    }

    override fun endProgress() {
        progressBar.visibility = INVISIBLE
    }

    override fun errorMessage() {
        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun initAdapter(products: List<ProductInfoModel>) {
        val adapter = ProductsAdapter(products, activity)
        val recyclerView : RecyclerView = view.findViewById(R.id.goods_recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity, VERTICAL, false)
        recyclerView.adapter = adapter
    }

    @InjectPresenter
    lateinit var mProdListPresenter: ProdListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.goods_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProdListPresenter.getProduts()
    }

    companion object {
        val TAG = "ProdListFragment"

        fun newInstance(): ProdListFragment {
            val fragment = ProdListFragment()

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }
}
