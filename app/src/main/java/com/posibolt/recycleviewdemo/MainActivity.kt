package com.posibolt.recycleviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val smartPhones = listOf<SmartPhones>(
        SmartPhones("S23 Ultra","Samsung"),
        SmartPhones("Iphone 14","Apple"),
        SmartPhones("S22 Ultra","Samsung"),
        SmartPhones("Iphone XR","Apple"),
        SmartPhones("Pixel 7 pro","Google"),
        SmartPhones("Pixel 5","Google"),
        SmartPhones("S20s","Samsung"),


        )
    override fun onCreate(savedInstanceState: Bundle?) {
        val placesName = listOf<String>("NewYork","Canada","Japan","Belgium","India")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.BLUE)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(smartPhones,{
            selectedPhones:SmartPhones -> listItemSelected(selectedPhones)
        })
    }
    private  fun listItemSelected(smartPhone:SmartPhones){
        Toast.makeText(this,"your selected ${smartPhone.modelName}",Toast.LENGTH_LONG).show()
    }
}