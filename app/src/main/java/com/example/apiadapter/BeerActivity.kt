package com.example.apiadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.beer_activity_list.*

class BeerActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_activity_list)
        rcvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val intent = this.intent
        var raza = intent.getStringExtra("RAZA").toLowerCase()
        txtHeader.text = "Raza del Perro: "+raza
        RequestVolley("https://api.punkapi.com/v2/beers?beer_name=lager")

    }

    private fun RequestVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                val gson = Gson()
                val listDogs = gson.fromJson(response,Results[].class).toList()
                val adaptador = BeerAdapter(listDogs)
                println(listDogs.results!!.get(0).image_url)
                println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                rcvList.adapter = adaptador
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }, Response.ErrorListener {  })
        queue.add(request)
    }
}