package com.example.appbluetooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.appbluetooth.databinding.ActivityMapsBinding
import com.google.android.gms.maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

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
        mMap = googleMap
        // Ajout d'un padding a droite afin d'y intégrer ensuite le volet des appareils disponibles
        mMap.setPadding(0,0,300,0)
        // Add a marker in Polytechnique Montreal and move the camera
        val poly = LatLng(45.505, -73.614)
        // addMarker permet d'ajouter un repère sur la carte, peut etre utilise pour mettre des repères pour chaque appareil bluetooth
        mMap.addMarker(MarkerOptions().position(poly).title("Marker in Polytechnique Montreal"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(poly))
    }
}