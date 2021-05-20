package com.bridgefy.samples.chat.Contacts

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDb: SQLiteOpenHelper(AppContactos.CONTEXT,AppContactos.DB_NAME,null, AppContactos.VERSION) {

    val qryCreaTabla="CREATE TABLE ${AppContactos.TB_CONTACTOS}(" +
            "${Contract.Contacto.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Contract.Contacto.NOMBRE} TEXTO NOT NULL," +
            "${Contract.Contacto.NUMERO} TEXTO NOT NULL); "

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreaTabla)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {  /*se ejecuta cuando se hace alguna
                                                                                 actualizacion en la base de datos*/

    }


}