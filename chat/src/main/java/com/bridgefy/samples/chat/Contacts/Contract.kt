package com.bridgefy.samples.chat.Contacts

import android.provider.BaseColumns

class Contract {

    //definimos los campos de la tabla

    class Contacto: BaseColumns{
        companion object{
            val ID = "id"
            val NOMBRE ="nombre"
            val NUMERO= "numero"
        }
    }
}