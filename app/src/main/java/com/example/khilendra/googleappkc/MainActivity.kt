package com.example.khilendra.googleappkc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.khilendra.googleappkc.R.id.btnGenerate
import com.example.khilendra.googleappkc.R.id.googleMapFragment
import com.example.khilendra.googleappkc.ui.main.MainFragment
import com.example.khilendra.googleappkc.ui.main.GoogleMapFragment

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }


        //Starting the logic here:

        //Setting up the button

        //Logic after button is clicked:

        //Setting up the fragment here

        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.mainScreen, mainFragment).commit()

    }


/*
    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()

        val googleMapFragment = GoogleMapFragment()

        googleMapFragment.arguments = bundle

        transaction.replace(R.id.mainScreen, googleMapFragment)
        transaction.commit()

    }

    internal fun onOpenMap() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, GoogleMapFragment())
            .commitNow()


    }

*/
}
