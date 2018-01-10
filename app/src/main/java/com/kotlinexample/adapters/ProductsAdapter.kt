package com.kotlinexample.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlinexample.R
import com.kotlinexample.activities.DetailProductActivity
import com.kotlinexample.api.ProductInfoModel
import com.kotlinexample.api.ProductSingleton
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: List<ProductInfoModel>, private val context: Context) : RecyclerView.Adapter<ProductsAdapter.MyAdapter>() {
    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: MyAdapter?, position: Int) {
        holder?.bindImage(products[position].img)
        holder?.bindText(products[position].text, products[position].text)
        holder?.bindOnClick(products[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAdapter = MyAdapter(LayoutInflater.from(context).inflate(R.layout.good_item, parent, false))


    class MyAdapter(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val v: View? = itemView
        private val img: ImageView? = v!!.findViewById(R.id.product_photo)
        private val title: TextView? = v!!.findViewById(R.id.title)
        private val text: TextView? = v!!.findViewById(R.id.text)

        fun bindImage(url: String){
            Picasso.with(v!!.context).load("http://smktesting.herokuapp.com/static/" + url).into(img)
        }

        fun bindText(text: String, title: String){
            this.text!!.text = text
            this.title!!.text = title
        }

        fun bindOnClick(product: ProductInfoModel, context: Context){
            v!!.setOnClickListener {
                val singleton = ProductSingleton
                singleton.id = product.id
                singleton.img = product.img
                singleton.text = product.text
                singleton.title = product.title
                val intent = Intent(context, DetailProductActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

}