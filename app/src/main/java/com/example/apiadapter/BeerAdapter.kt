package com.example.apiadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.beer_cardview.view.*

class BeerAdapter (var list:ArrayList<String>): RecyclerView.Adapter<BeerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerAdapter.ViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.beer_cardview,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BeerAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data:String){
            Glide.with(itemView.context).load(data).into(itemView.thumbnail)
        }
    }
}