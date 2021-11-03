package com.bridgefy.samples.chat

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.*

class MainApi constructor(context: Context) {
    companion object{
        @Volatile
        private var INSTANCE: MainApi?=null

        fun getInstance(context: Context) = INSTANCE?: synchronized(this){
            INSTANCE ?: MainApi(context).also { INSTANCE= it }
        }


    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}