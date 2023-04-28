package com.example.projetba2informatique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var Scan:Button
    lateinit var Rent:Button
    lateinit var Next:Button
    lateinit var Stop:Button

    private val ecurie = Ecurie()
    private val nombre_trotinette = 30
    private val nombre_voiture = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Scan = findViewById(R.id.Scan)
        Rent = findViewById(R.id.Rent)
        Stop = findViewById(R.id.stp)
        val solde = findViewById<TextView>(R.id.solde)

        val Solde = solde.text.toString().toDouble()
        var numero = 0
        var listvehicules = arrayListOf<Observer>() // Quelques problèmes de liste


        for(i in 1.rangeTo(nombre_trotinette)){ // Initialise les trotinettes
            ecurie.add(Trotinette(i))
        }
        for(i in 1.rangeTo(nombre_voiture)){ //Initialise les voitures
            ecurie.add(Voiture(i))
        }

        Scan.setOnClickListener{
            ecurie.hasUpdated()
            listvehicules = ecurie.vehicules
            numero = 0
            val length = listvehicules.size








        }
        Rent.setOnClickListener{
            listvehicules.get(numero)
        }
        Next.setOnClickListener{
            numero += 1
        }
        Stop.setOnClickListener{
            val CarburantRestant = listvehicules.get(numero).moteur.getCarburantRestant().toDouble()
            val CarburantConsome = listvehicules.get(numero).moteur.consomer().toDouble()
            solde.text = Account.debit(Solde,CarburantRestant,CarburantConsome).toString()

        }
    }
}