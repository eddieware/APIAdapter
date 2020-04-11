package com.example.apiadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.beer_cardview.view.*

class BeerAdapter (var list:ArrayList<Results>): RecyclerView.Adapter<BeerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerAdapter.ViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.beer_cardview,parent,false)



        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BeerAdapter.ViewHolder, position: Int) {
       holder.bindItem(list[position])
        val objResults= (list[position])
        holder?.itemView.name.text=objResults.name
        holder?.itemView.txtdescripcion.text=objResults.description
        holder?.itemView.txtprecio.text=objResults.ebc.toString()



    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data:Results){



            Glide.with(itemView.context).load(data.image_url).into(itemView.thumbnail)
        }
    }
}


