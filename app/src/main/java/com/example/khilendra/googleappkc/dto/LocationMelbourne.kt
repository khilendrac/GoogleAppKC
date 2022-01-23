package com.example.khilendra.googleappkc.dto

data class LocationMelbourne(var typeId: String, var departureTime:String, var name:String, var latitude:String, var longitude:String, var isExpress:String, var hasMyKiTopUp:String  ) {

    override fun toString(): String {
        return name
    }
}