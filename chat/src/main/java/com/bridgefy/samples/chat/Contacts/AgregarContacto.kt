package com.bridgefy.samples.chat.Contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.R
import kotlinx.android.synthetic.main.activity_agregar_contacto.*

class AgregarContacto : AppCompatActivity() {

    val contactoAdmin = AdminContacto()    //crear objeto de la clase Admin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)
        guardarContacto_click()  /*este si se invoca desde el OnCreate ya que nunca nos vamos a salir de aqui,
                                y cuando nos salgamos sera porque ya se hizo lo que se tenia que hacer*/
    }

    fun guardarContacto_click(){
        btnGuardar.setOnClickListener(){
            val contacto = Contacto (0, txNombre.text.toString(), txNumero.text.toString())//crear objeto de la clase Contacto
            contactoAdmin.addContacto(contacto)
            finish()


        }
    }
}