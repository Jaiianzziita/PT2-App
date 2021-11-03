package com.bridgefy.samples.chat

import android.app.Application

class LoginApplication: Application(){

    companion object{
        lateinit var mainApi: MainApi
    }

    override fun onCreate() {
        super.onCreate()

        //Volley
        mainApi= MainApi.getInstance(this)
    }

}