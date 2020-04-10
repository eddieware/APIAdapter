package com.example.apiadapter

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchBtn.setOnClickListener {
            if (Network.hayRed(this)) {
                val intLista = Intent(this,BeerActivity::class.java)
                intLista.putExtra("RAZA",edtxtRaza.text.toString())
                startActivity(intLista)
            }else{
                Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
            }
        }
    }
}
