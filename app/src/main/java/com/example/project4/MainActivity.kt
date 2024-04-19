package com.example.project4

import android.icu.text.Transliterator.Position
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        displayCheckBox()

        //radio button
        displayRadio()

        //Spinner
        displaySpinner()

        // time pickers
        //dispalyTimepicker()

        // date picker
        displayDatepicker()

        //Progress bar
        progressBar()




    }
    fun displaySpinner() {
        val  spinner: Spinner = findViewById(R.id.mySpinner)

        val operatingSystem = arrayOf("Windows", "Mac", "IOS", "Android")

        val adapters = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            operatingSystem
        )

        spinner.adapter = adapters

        // Handling Spinner
        spinner.onItemSelectedListener = object :
         AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //val selectedItem = parent?.getItemAtPosition(position).toString()
                val selectedItem2 = operatingSystem[position]
                Toast.makeText(applicationContext, "you selected $selectedItem2", Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun displayRadio() {
       val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
       val neel = findViewById<RadioButton>(R.id.neelRadio)
       val yash = findViewById<RadioButton>(R.id.yashRadio)
       val raj = findViewById<RadioButton>(R.id.rajRadio)

       // detechting selected redio button
       radioGroup.setOnCheckedChangeListener{ radioGroup, checked ->
           when(checked){
               R.id.neelRadio -> {
                  Toast.makeText(this, "you checked Neel", Toast.LENGTH_LONG).show()
               }
               R.id.yashRadio -> {
                   Toast.makeText(this, "you checked yash", Toast.LENGTH_LONG).show()
               }
               R.id.rajRadio -> {
                   Toast.makeText(this, "you checked raj", Toast.LENGTH_LONG).show()
               }
           }

       }

    }

    fun displayCheckBox(){
        val checkBox = findViewById<CheckBox>(R.id.checkBox)

        checkBox.setOnCheckedChangeListener{ _ , isChecked ->
            if (isChecked){
                Toast.makeText(this, "You Checked the Play", Toast.LENGTH_LONG).show()
            }
            else{
                //
            }
        }
    }

//    fun dispalyTimepicker(){
//        val timePicker: TimePicker = findViewById(R.id.timePicker)
//
//        // handiling the change in time
//        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
//            //view -> represent the TimPicker itself
//            //hourOFDay -> selected hour in 24 hour Format
//            // minute -> selected minute
//
//            //formatting selected time
//            val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
//            Toast.makeText(applicationContext, "Your time is $selectedTime", Toast.LENGTH_LONG).show()
//
//
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun displayDatepicker(){
        val datePicker: DatePicker = findViewById(R.id.datePicker)

        // Handling date cchnge
        datePicker.setOnDateChangedListener { datePicker, year, monthOfYear, dayOfMonth ->
            Toast.makeText(applicationContext, "Year: $year, Month: ${monthOfYear+1}, Day: $dayOfMonth", Toast.LENGTH_SHORT).show()
        }
    }

    fun progressBar(){
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        val progressValue = 60
        progressBar.progress = progressValue
    }
}