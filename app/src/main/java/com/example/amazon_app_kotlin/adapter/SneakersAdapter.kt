package com.example.amazon_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon_app_kotlin.R
import com.example.amazon_app_kotlin.model.Essential
import com.example.amazon_app_kotlin.model.Sneakers
import com.google.android.material.imageview.ShapeableImageView

class SneakersAdapter(var context: Context,var items:ArrayList<Sneakers>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products_layout,parent,false)
        return SneakersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var item = items[position]
        if(holder is SneakersViewHolder){
        var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
        }

    }

    override fun getItemCount(): Int {
       return items.size
    }
}

class SneakersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var iv_image: ImageView

    init {
        iv_image = view.findViewById(R.id.iv_sneakers)
    }

}
