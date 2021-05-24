package com.bridgefy.samples.chat.Maps

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bridgefy.samples.chat.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class Maps : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1//constante para identificar el permiso que estamos pidiendo, puede ser cualquier numero
    }

    override fun onMarkerClick(p0: Marker?)=false   //con este metodo decimos que queremos hacer con nuestro mapa



    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient= LocationServices.getFusedLocationProviderClient(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

      /*  // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))           */

        map.setOnMarkerClickListener (this)  //this -> que esta actividad se encargara de los mapas
        map.uiSettings.isZoomControlsEnabled= true      // esto activa los controles de zoom

        setUpMap()
    }

    private fun placeMarker (location: LatLng){
        val markerOption = MarkerOptions().position(location)
        markerOption.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))//cambiar color del marcador
        map.addMarker(markerOption)
    }


    private fun setUpMap(){  //este metodo checa que tengamos un permiso en especifico en este caso acces_fine_location
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){ //el packagemanager dice si tenemos un cierto permiso o no
            ActivityCompat.requestPermissions(this,  // en caso de que no lo tengamos utilizamos el metodo ActivityCompat llamado RequestPermission
            //se pide un permiso, pero se pueden pedir varios por eso se pone arrayof. En este caso solo se pide el de FINE y se le pasa
                    // un codigo de nuestro permiso en este caso LOCATION_PERMISSION_REQUIEST_CODE
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        map.isMyLocationEnabled=true //desplegara nuestra ubicacion. Lo que hace es que añade una capa encima de nuestro mapa donde se pone el puntito azul para desplegar la ubicacion del usuario
       map.mapType = GoogleMap.MAP_TYPE_HYBRID
        fusedLocationClient.lastLocation.addOnSuccessListener (this){location->  //esta llamada se va a ejecutar cuando hayamos obtenido una localizacion del usuario
            if (location!= null){
                lastLocation=location
                val currentLatLong = LatLng(location.latitude, location.longitude)
                placeMarker(currentLatLong)
                //este metodo se lo vamos a pasar a la siguiente para que se mueva la camara a nuestra ubicacion:
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 13f))//0-20 en zoom donde 0 es el mas alejado, 20 mas cercano.
            }
        }

    }
}