package com.example.khilendra.googleappkc.service

import androidx.lifecycle.MutableLiveData
import com.example.khilendra.googleappkc.dto.LocationMelbourne

class LocationService {

    fun fetchLocations(locationName: String) : MutableLiveData<ArrayList<LocationMelbourne>> {

        return MutableLiveData<ArrayList<LocationMelbourne>>()

    }
}