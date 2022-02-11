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
import com.google.android.material.imageview.ShapeableImageView

class EssentialAdapter(var context: Context,var items:ArrayList<Essential>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cutom_layout,parent,false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var item = items[position]
        if(holder is EssentialViewHolder){
        var tv_title = holder.tv_title
        var iv_image = holder.iv_image

            tv_title.text = item.title
            iv_image.setImageResource(item.image)
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }
}

class EssentialViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tv_title:TextView
    var iv_image: ImageView

    init {
        tv_title = view.findViewById(R.id.tv_title)
        iv_image = view.findViewById(R.id.iv_image)
    }

}
