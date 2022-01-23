package com.example.khilendra.googleappkc

import android.location.Location
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.khilendra.googleappkc.dto.LocationMelbourne
import com.example.khilendra.googleappkc.service.LocationService
import com.example.khilendra.googleappkc.ui.main.MainViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import kotlin.collections.forEach as forEach1

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MapDataUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    lateinit var mvm:MainViewModel

    @get: Rule
    var rule: TestRule = InstantTaskExecutorRule()


    var locationService = mockk<LocationService>()

    @Test
    fun confirmFlinders_outputsFlinders () {

        //This function tests for the location given
        var location: LocationMelbourne = LocationMelbourne(
            "0",
            "2021-07-03T09:10:00.000Z",
            "Flinders",
            "-37.8181755",
            "144.9661256",
            "",
            ""
        )
        assertEquals("Flinders", location.toString())

    }

    @Test
    fun searchForFlinders_returnsFlinders() {
        //This function will search for Flinders
        givenAFeedOfMapDataAreAvaliable()
        whenSearchForFlinders()
        thenResultContainsFlinders()
    }
    private fun givenAFeedOfMapDataAreAvaliable() {
        mvm = MainViewModel()
        createMockData()
    }

    private fun createMockData() {
        var allLocationsLiveData = MutableLiveData<ArrayList<LocationMelbourne>>()
        var allLocations = ArrayList<LocationMelbourne> ()

        //Create and add locations to our collections

        var flinders = LocationMelbourne("0", "2021-07-03T09:10:00.000Z",
            "Flinders", "-37.8181755", "144.9661256","", "")
        allLocations.add(flinders)

        allLocationsLiveData.postValue(allLocations)

        every {locationService.fetchLocations(any<String>())} returns allLocationsLiveData
        mvm.locationService = locationService

    }


    private fun whenSearchForFlinders() {
        mvm.fetchLocations("Flinders")
    }


    private fun thenResultContainsFlinders() {
        var flindersFound = false
        mvm.locations.observeForever {
            // Here is where we do observing
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach {
                if (it.typeId=="0" && it.departureTime=="2021-07-03T09:10:00.000Z" && it.name=="Flinders" &&
                    it.latitude=="-37.8181755" && it.longitude=="144.9661256") {

                    flindersFound = true
                }
            }
        }
        assertTrue(flindersFound)
    }


    @Test
    fun searchForGarbage_returnsNothing() {
        //This function looks for garbage data found
        givenAFeedOfMapDataAreAvaliable()
        whenISearchForGarbage()
        thenIGetZeroResults()


    }



    private fun whenISearchForGarbage() {
        mvm.fetchLocations("sdfasdfgerjkrghkjasdf")
    }


    private fun thenIGetZeroResults() {
        mvm.locations.observeForever {
            assertEquals(0, it.size)
        }

    }


}