package com.bridgefy.samples.chat.Contacts

import android.app.Application
import android.content.Context

//solo se puede hacer un archivo de estos

//aqui estan los metadatos de la base de datos

class AppContactos: Application (){

    companion object    {    //para variables estaticas
        lateinit var CONTEXT: Context
        val DB_NAME= "ContactosDB.db"  //es un archivo de BD tipo sqlite que se guardara en el telefono
        val VERSION= 1  //mientras no se hagan modificaciones a la base de datos seguira siendo 1
        val TB_CONTACTOS="tbContactos"  //nombre de la tavla
}
    override fun onCreate() {
        super.onCreate()

        CONTEXT=applicationContext
    }
}