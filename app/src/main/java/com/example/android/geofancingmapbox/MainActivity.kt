package com.example.android.geofancingmapbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.android.core.location.LocationEngine
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import android.support.annotation.NonNull



class MainActivity : AppCompatActivity(), PermissionsListener, OnMapReadyCallback {

    // Variables needed to initialize a map
    private lateinit var mapView: MapView
    private lateinit var map: MapboxMap

    // Variables needed to handle location permissions
    private var permissionsManager: PermissionsManager = PermissionsManager(this)

    // Variables needed to add the location engine
    private lateinit var locationEngine: LocationEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token))
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)


    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        map = mapboxMap
//        mapboxMap.setStyle(Style.MAPBOX_STREETS, Style.OnStyleLoaded() {
//            fun onStyleLoaded(style: Style) {
//
//        }
//        })
        mapboxMap.setStyle(
            Style.MAPBOX_STREETS
        ) { style -> enableLocationComponent(style) }
    }

    private fun enableLocationComponent(loadedMapStyle: Style) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {

        } else {

        }
    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
    }

    override fun onPermissionResult(granted: Boolean) {
//        if (granted) {
//
//        } else {
//            finish()
//        }
    }

    @SuppressWarnings("MissingPermission")
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            mapView.onSaveInstanceState(outState)
        }
    }
}
