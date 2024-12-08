package com.example.tareafinal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tareafinal.databinding.ActivityMapaBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapaBinding
    private lateinit var mMap: GoogleMap
    private var selectedMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        // Asegúrate de que el id "map" coincide con el fragmento en el archivo XML
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as com.google.android.gms.maps.SupportMapFragment

        // Configurar el mapa
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Mover la cámara al centro del mundo
        val mundo = LatLng(0.0, 0.0)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mundo, 2f))

        // Configurar un listener para marcar ubicaciones
        mMap.setOnMapClickListener { latLng ->
            // Eliminar marcador anterior, si existe
            selectedMarker?.remove()

            // Crear un nuevo marcador
            selectedMarker = mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("Lugar favorito")
            )

            // Mostrar coordenadas seleccionadas
            Toast.makeText(
                this,
                "Lugar seleccionado: ${latLng.latitude}, ${latLng.longitude}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
