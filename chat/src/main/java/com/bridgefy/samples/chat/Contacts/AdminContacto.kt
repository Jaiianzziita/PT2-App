package com.bridgefy.samples.chat.Contacts

import android.database.DatabaseUtils
import android.widget.Toast

data class Contacto (var id:Int, var nombre:String, var numero:String)

//practicamente aqui declaramos el arreglo, hacemos toda la qry, regresamos los nombres

class AdminContacto {
    //Qry que nos regrese los nombres de los contactos guardados
    fun getAllNames():ArrayList<String>?{
       try {
           //Respuesta
           val nombres = arrayListOf<String>()
           val db= AppContactos.DB.readableDatabase  //aqui solo es lectura
           //Checamos si hay datos guardador
           val numDatos = DatabaseUtils.queryNumEntries(db, AppContactos.TB_CONTACTOS).toInt() //regresa en formato numerico
            if (numDatos > 0){
                val qry = "SELECT ${Contract.Contacto.NOMBRE} FROM ${AppContactos.TB_CONTACTOS}"
                val c =db.rawQuery(qry, null)  //guardar lista
                // nos ponemos al inicio de la tabla
                c.moveToFirst()
                do {
                    //rellenamos el arreglo de respuesta
                    nombres.add(c.getString(c.getColumnIndex(Contract.Contacto.NOMBRE)))
                }while (c.moveToNext())


            }else{
                Toast.makeText(AppContactos.CONTEXT, "No hay contactos guardados", Toast.LENGTH_SHORT).show()

            }
           db.close()
           return nombres

       }catch (ex:Exception){
           Toast.makeText(AppContactos.CONTEXT, "No se pudo recuperar la lista", Toast.LENGTH_SHORT).show()
           return null
       }
    }


    //Qry que permita insertar un contacto
    fun addContacto(contacto: Contacto){
                //todas las operaciones importantes hay que encapsularlas con un try and catch
        try{
            val db = AppContactos.DB.writableDatabase  //para escribir en la base de datos
            var qry ="INSERT INTO ${AppContactos.TB_CONTACTOS} (" +
                    "${Contract.Contacto.NOMBRE}, ${Contract.Contacto.NUMERO}" +  //el id no se coloca ya que de todos modos incrementara automaticamente
                    "VALUES('${contacto.nombre}', '${contacto.numero}');"  //toma el valor de Contacto y va al objeto nombre y numero
            db.execSQL(qry)
            db.close()  //siempre debe cerrarse
        } catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT, "No se pudo guardar el contacto", Toast.LENGTH_SHORT).show()
        }
    }
}