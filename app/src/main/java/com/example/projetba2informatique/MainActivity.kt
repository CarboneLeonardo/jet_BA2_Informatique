package com.example.projetba2informatique

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var Scan:Button
    lateinit var Rent:Button
    lateinit var Next:Button
    lateinit var Stop:Button
    lateinit var descriptif:TextView

    private val ecurie = Ecurie()
    private val nombre_trotinette = 10
    private val nombre_voiture = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Next = findViewById(R.id.Next)
        Scan = findViewById(R.id.Scan)
        Rent = findViewById(R.id.Rent)
        Stop = findViewById(R.id.stp)

        descriptif = findViewById(R.id.type)
        val solde = findViewById<TextView>(R.id.solde)

        val Solde = solde.text.toString().toDouble()
        var liste_vehicules = arrayListOf<Observer>()
        var numero = 0
        var length = 0



        for(i in 1.rangeTo(nombre_trotinette)){ // Initialise les trotinettes
            ecurie.add(Trotinette(i))
        }
        for(i in 1.rangeTo(nombre_voiture)){ //Initialise les voitures
            ecurie.add(Voiture(i))
        }
        // 1er Boutton UwU
        Scan.setOnClickListener{
            liste_vehicules = ecurie.hasUpdated() // return: Liste contenant les vehicules utilisables à moins de 200m
            length = liste_vehicules.size // Enregistre le nombre de vehicules utilisables
            val text = liste_vehicules.get(numero).describe() // Liste contenant toutes les infos à montrer su l'interface graphique
            // Reste plus qu'a changer l'interface graphique pour ce boutton !
            descriptif.text = text


        }
        Rent.setOnClickListener{

            Next.visibility = View.INVISIBLE


        }
        Next.setOnClickListener{
            // Permet de passer d'un vehicule à un autre, et donc de revenir sur le vehicule initiale
            // s'arrete si: - Appuie sur le bouton "cancel"
            //              - Appuie sur le bouton "Rent"
            numero += 1
            if(numero==length){numero=0}
            val text = liste_vehicules.get(numero).describe()
            descriptif.text = text



        }
        Stop.setOnClickListener{
            Next.visibility = View.VISIBLE
            val CarburantRestant = ecurie.vehicules.get(numero).moteur.getCarburantRestant()
            val CarburantConsome = ecurie.vehicules.get(numero).moteur.consomer()
            solde.text = Account.debit(Solde,CarburantRestant,CarburantConsome).toString()


        }
    }
}