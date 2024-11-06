package com.example.requisiojsoncomvolley

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MySingleton private constructor(context: Context) {
    private var requestQueue: RequestQueue? = null
    private val ctx: Context = context.applicationContext

    companion object {
        @Volatile
        private var instancia: MySingleton? = null

        fun getInstance(context: Context): MySingleton {
            return instancia ?: synchronized(this) {
                instancia ?: MySingleton(context).also { instancia = it }
            }
        }
    }

    fun getRequestQueue(): RequestQueue {
        return requestQueue ?: run {
            requestQueue = Volley.newRequestQueue(ctx)
            requestQueue!!
        }
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        getRequestQueue().add(req)
    }
}
