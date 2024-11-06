package com.example.requisiojsoncomvolley

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)

        requisicao()
    }

    private fun requisicao() {
        val url = "https://linuxjf.com/pdm2_aula2.php"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                textView.text = "Resposta: $response"
            },
            { error ->
                textView.text = "Algo deu errado!"
            }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}
