package com.example.projetba2informatique
import android.graphics.Color

class Button {

    //var color = color.argb()
    val vehicule : arraylistOf<Vehicule>()
    lateinit var ecurie: Ecurie
    var compteur = 1

    fun Scan(num:Int){

    // 2)display sur l'interface graphique les infomartions relatives au vehicule.
        ecurie.hasUpdated(vehicule) // Doit rendre une liste contenant tous les vehicules possibles
    // 3) Doit "show" les vehicules
        vehicule(compteur).describe()
    }
    fun next(){

        vehicule(compteur).describe()





    }

    fun Rent(){
        // 1) demande au vehicule de s'update comme "unsuable"
        // 2)



    }

    fun StopRent(){
        // 1) Mettre le véhicule(...a voir avec le moteur...)
        // 2)




    }
}