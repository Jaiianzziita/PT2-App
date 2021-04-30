package com.bridgefy.samples.chat.Profile

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.bridgefy.samples.chat.R
import com.bridgefy.samples.chat.TabsActivity
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_signup.*

class Profile : AppCompatActivity() {
    private val REQUEST_GALERY = 1003
    private val REQUEST_CAMERA = 1004
    var foto2: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        abreGaleria2_Click()
        abreCamara2_Click()


        var topAppBar3: MaterialToolbar = findViewById(R.id.topAppBar3)

        topAppBar3.setOnClickListener({
            val intent: Intent = Intent(this, TabsActivity::class.java)
            startActivity(intent)
        })
    }

    //DETECTAMOS CUANDO SE PULSE EL BOTON PARA ABRIR LA CAMARA
    private fun abreCamara2_Click() {
        btnCamera2.setOnClickListener() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                        || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    //PEDIRLE PERMISOS AL USUARIO CAMARA
                    val permisosCamara = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permisosCamara, REQUEST_CAMERA)
                } else {
                    abreCamara2()
                }
            } else {
                abreCamara2()
            }
        }
    }

    //DETECTAMOS CUANDO SE PULSE EL BOTON PARA ABRIR LA GALERIA
    private fun abreGaleria2_Click() {
        btnGaleria2.setOnClickListener() {
            //muestraGaleria()
            //VERIFICAMOS QUE VERSION DE ANDROID ESTA INTALADA EN EL TELEFONO
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    //PEDIR PERMISO AL USUARIO
                    val permisoArchivos = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoArchivos, REQUEST_GALERY)
                } else {  //ENTONCES SI TIENE PERMISO
                    muestraGaleria2()
                }
            } else {//TIENE VERSIOND E LOLIPOP HACIA ABAJO Y POR DEFAULT TIENE PERMISO
                muestraGaleria2()
            }
        }
    }

    //CHECAMOS SI EL USUARIO DIO PERMISO A LA APLICACION
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_GALERY -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    muestraGaleria2()
                else
                    Toast.makeText(applicationContext, "No puedes acceder a tus imagenes", Toast.LENGTH_SHORT).show()
            }

            REQUEST_CAMERA -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    abreCamara2()
                else
                    Toast.makeText(applicationContext, "No puedes acceder a la camara", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //ABRE LA VENTANA DONDE SE MUESTRA LA GALERIA DE FOTOS
    private fun muestraGaleria2() {
        // Toast.makeText(applicationContext, "Aqui van las imagenes", Toast.LENGTH_SHORT).show()
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria, REQUEST_GALERY)
    }


    //ABRE LA CAMARA DEL TELEFONO Y PERMITE TOMAR LA FOTO
    private fun abreCamara2() {
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE, "Nueva imagen")
        foto2 = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, foto2)
        startActivityForResult(camaraIntent, REQUEST_CAMERA)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_GALERY) {
            profilephoto.setImageURI(data?.data)
        }
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA) {
            profilephoto.setImageURI(foto2)

        }


    }
}