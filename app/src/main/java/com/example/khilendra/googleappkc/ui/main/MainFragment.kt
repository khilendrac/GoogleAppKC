package com.example.khilendra.googleappkc.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.viewbinding.ViewBindings
import com.example.khilendra.googleappkc.Communicator
import com.example.khilendra.googleappkc.MainActivity
import com.example.khilendra.googleappkc.R


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var communicator: Communicator

    //Actual variables to pass after validation
    private var transportType = ""
    private var express = ""
    private var mykiTopup = ""

    //Flags to validate
    private var flag1 = true
    private var flag2 = true
    private var flag3 = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.main_fragment, container, false)

        // variables assigned with the ids
        val btnGen = view.findViewById<View>(R.id.btnGenerate) as ImageButton
        val radioGrp1 = view.findViewById<View>(R.id.radioGroupTransportType) as RadioGroup
        val radioGrp2 = view.findViewById<View>(R.id.radioGroupExpress) as RadioGroup
        val radioGrp3 = view.findViewById<View>(R.id.radioGroupMyki) as RadioGroup
        val errorText = view.findViewById<View>(R.id.errorMessage) as TextView


        // Listener for the main generate button
        btnGen.setOnClickListener {
            errorText.setText("")
            //Validating Train or Tram Radio Button Selection
            val checkedRadioTransportTypeId = radioGrp1.checkedRadioButtonId
            val trainOrTram = view.findViewById<RadioButton>(checkedRadioTransportTypeId)
            if(trainOrTram == null) {
                //validation for Transport Type: Train or Tram to be selected
                flag1 = false
            }else {
                flag1 = true
                transportType = trainOrTram.text as String
                //Displayed the value on the screen to test it
                //errorText.setText(transportType)
            }

            //Validating Express or not
            val checkedRadioExpressId = radioGrp2.checkedRadioButtonId
            val expressOrNot = view.findViewById<RadioButton>(checkedRadioExpressId)
            if(expressOrNot == null) {
                //validation for Express: Yes or No to be selected
                flag2 = false
            }else {
                flag2 = true
                express = expressOrNot.text as String
                //Displayed the value on the screen to test it
                //errorText.setText(express)
            }


            //Validating Myki Top up Present of not
            val checkedRadioMykiId = radioGrp3.checkedRadioButtonId
            val mykiOrNot = view.findViewById<RadioButton>(checkedRadioMykiId)
            if(mykiOrNot == null) {
                //validation for Myki Topup Station: Yes or No to be selected
                flag3 = false
            }else {
                flag3 = true
                mykiTopup = mykiOrNot.text as String
                //Displayed the value on the screen to test it
                //errorText.setText(mykiTopup)
            }


            if (flag1 && flag2 && flag3) {
                //Validation is successful
                //Setting up the values in order to pass to google map fragment
                val bundle = Bundle()
                bundle.putString("data1",transportType)
                bundle.putString("data2", express)
                bundle.putString("data3", mykiTopup)

                //Calling the fragment and passing the arguments
                val fragmentGoogleMap = GoogleMapFragment()
                fragmentGoogleMap.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.container, fragmentGoogleMap)?.commit()


            } else
                //Setting up error message on the screen as per the error occurance
                if (!flag1) {
                    errorText.setText("Please select Transport Type!")
                }else if (!flag2) {
                    errorText.setText("Please select Express or Not!")
                }else if (!flag3) {
                    errorText.setText("Please select Myki Topup or Not!")
                }
            }



        /*
        communicator = activity as Communicator
        btnGen.setOnClickListener {
            validate()
            if(flag1) {
            } else {
                communicator.passDataCom("done")
            }
        }
        */

        return view

    }





}