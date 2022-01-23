package com.example.khilendra.googleappkc.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khilendra.googleappkc.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class GoogleMapFragment : Fragment() {


    private lateinit var mMap : GoogleMap
    private var mapReady = false

    //Variables to hold the values passed from another Fragment
    private var transportType = ""
    private var express = ""
    private var mykiTopup = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_google_map, container, false)

        //Pulling the value from the main fragment
        val args = this.arguments
        val data1 = args?.get("data1")
        val data2 = args?.get("data2")
        val data3 = args?.get("data3")

        //Converting the values to string

        transportType = data1.toString()
        express = data2.toString()
        mykiTopup = data3.toString()

        val mapFragment = childFragmentManager.findFragmentById(R.id.googleMapFragment) as SupportMapFragment
        //syncing with the map
        mapFragment.getMapAsync {
            googleMap -> mMap = googleMap
            mapReady = true
            updateMap()

        }
        return rootView

    }

    private fun updateMap() {
        //Setting up the latitudes and longitudes
        val marker = LatLng(-33.8688,151.2093)
        //Positioning the map
        mMap.addMarker(MarkerOptions().position(marker).title("Sydney"))
        //Zooming to the coordinates
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 10f))


    }





}