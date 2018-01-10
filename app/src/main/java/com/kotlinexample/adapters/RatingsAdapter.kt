package com.kotlinexample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlinexample.R
import com.kotlinexample.api.ProductReviewModel

class RatingsAdapter(private val products: List<ProductReviewModel>?, private val context: Context) : RecyclerView.Adapter<RatingsAdapter.MyAdapter>() {

    override fun onBindViewHolder(holder: MyAdapter?, position: Int) {
        holder!!.bindView(products!![position])
    }

    override fun getItemCount(): Int = products!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAdapter  = MyAdapter(LayoutInflater.from(context).inflate(R.layout.rating_item, parent, false))

    class MyAdapter(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val v: View? = itemView
        private val user: TextView? = v!!.findViewById(R.id.user)
        private val rating: TextView? = v!!.findViewById(R.id.rating)
        private val comment: TextView? = v!!.findViewById(R.id.comment)

        fun bindView(product: ProductReviewModel){
            user!!.text = product.created_by.username
            rating!!.text = product.rate.toString()
            comment!!.text = product.text
        }
    }


}