package com.example.projetba2informatique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var ecurie : Ecurie

    private val nombre_trotinette = 30
    private val nombre_voiture = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val solde = findViewById<TextView>(R.id.solde)
        var Solde = solde.text.toString().toDouble()

        for(i in 1.rangeTo(nombre_trotinette)){ // Initialise les trotinettes
            ecurie.add(Trotinette(i))
        }
        for(i in 1.rangeTo(nombre_voiture)){ //Initialise les voitures
            ecurie.add(Voiture(i))
        }






    }
}