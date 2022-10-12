package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
//import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject

//import java.nio.ByteBuffer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val share =findViewById<Button>(R.id.ShareButton)
        val next  =findViewById<Button>(R.id.NextButton)
//        val image = findViewById<ImageView>(R.id.MemeImgView)



        loadMeme()
        share.setOnClickListener {
//            Toast.makeText(this,"share was clicked",Toast.LENGTH_SHORT).show()

        }

        next.setOnClickListener {
//            Toast.makeText(this,"next was clicked",Toast.LENGTH_SHORT).show()
            loadMeme()
        }

    }

    private fun loadMeme(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val url= response.getString("url")
                val memeImg= findViewById<ImageView>(R.id.MemeImgView)
                Glide.with(this).load(url).into(memeImg)

            },

            Response.ErrorListener{
               Toast.makeText(this, "something went wrong",Toast.LENGTH_SHORT).show()
            })

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)

    }





}