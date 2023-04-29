package com.example.projetba2informatique

import kotlin.random.Random

class Voiture(override val QRcode: Int):Vehicule(){

    override val type = "Voiture"
    override val Capacite = Random.nextInt(1,100)
    private val Carburant = Random.nextDouble(0.3,0.9)

    override val moteur : Moteur = Moteur(Capacite,Carburant)


//    override fun describe(){
//        // 1) donnes les imforamtions suivantes :
//        // val info = moteur.consomer()
//        val Carburant = moteur.getCarburantRestant()
//        val text = arrayOf(type,"$QRcode","$position","$Capacite","$Carburant")
//
//    }



}