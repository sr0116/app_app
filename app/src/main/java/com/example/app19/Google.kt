package com.example.app19

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Google : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.google)

        if (savedInstanceState == null) {
            val mapFragment = SupportMapFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.map_fragment_container, mapFragment)
                .commit()

            mapFragment.getMapAsync { googleMap ->
                val seoul = LatLng(37.56, 126.97)
                googleMap.addMarker(MarkerOptions().position(seoul).title("Marker in Seoul"))
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 14f))
            }
        }
    }
}
