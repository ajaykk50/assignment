package com.assignment.interviewassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assignment.interviewassignment.R
import com.assignment.interviewassignment.data.remote.response.productsItem
import com.assignment.interviewassignment.databinding.ListItemBinding
import com.squareup.picasso.Picasso


class ProductsAdapter(
    val onItemClicked: ((product: productsItem) -> Unit)
) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {
    private val productList = ArrayList<productsItem>()

    fun setList(products: List<productsItem>) {
        productList.clear()
        productList.addAll(products)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class MyViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(products: productsItem) {
            Picasso.get()
                .load(products.thumbnailUrl)
                .into(binding.ivImage)

            binding.ivImage.setOnClickListener {
                onItemClicked(products)
            }
        }
    }
}


