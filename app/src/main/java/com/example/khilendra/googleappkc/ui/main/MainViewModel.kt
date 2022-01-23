package com.example.khilendra.googleappkc.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khilendra.googleappkc.dto.LocationMelbourne
import com.example.khilendra.googleappkc.service.LocationService

class MainViewModel : ViewModel() {
    var locations: MutableLiveData<ArrayList<LocationMelbourne>> = MutableLiveData<ArrayList<LocationMelbourne>>()

    var locationService: LocationService = LocationService()
    fun fetchLocations(locationName: String) {

        locations = locationService.fetchLocations(locationName)

    }

}