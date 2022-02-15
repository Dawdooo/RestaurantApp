package com.example.restaurantapp

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val wroll =LatLng(51.081703, 17.048730)
        val wwall =LatLng(52.242260, 21.084980)
        val krkll=LatLng(50.069897, 19.937259)
        val gdll =LatLng(54.416584, 18.589639)
        val start = LatLngBounds(LatLng(51.759445, 	19.457216),  // SW bounds
            LatLng(51.759445, 19.457216)// NE bounds
        )

        googleMap.addMarker(MarkerOptions().position(wroll).title("Wrocław,Krzyki").snippet("Bardzka 3"))
        googleMap.addMarker(MarkerOptions().position(wwall).title("Warszawa,Praga-Południe").snippet("Czapelska 21"))
        googleMap.addMarker(MarkerOptions().position(krkll).title("Kraków,Nowy Kleparz").snippet("Długa 33"))
        googleMap.addMarker(MarkerOptions().position(gdll).title("Gdańsk,Przymorze Wielkie").snippet("Piastowska 90"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start.center, 6f))


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}