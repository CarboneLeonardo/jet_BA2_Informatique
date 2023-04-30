package com.example.projetba2informatique

import kotlin.random.Random

class Trotinette(override val QRcode:Int):Vehicule(){

    override val type = "Trotinette"
    override val Capacite = 25
    private val Carburant = Random.nextDouble(0.3,0.9)

    override val moteur : Moteur = Moteur(Capacite,Carburant)


//    override fun describe(){
//
//
//    }


}
