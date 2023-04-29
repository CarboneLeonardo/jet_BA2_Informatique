package com.example.projetba2informatique

import kotlin.random.Random

abstract class Vehicule() : Observer {
    // Position= une valeur Random entre 1m et 1000m
    protected var Usable = true
    protected var position = Random.nextInt(1,1000)

    abstract val QRcode :Int
    abstract val type : String
    abstract val Capacite : Int


    override fun Update():Boolean { // A voir si on change pas le nom de "Update" par "Scan".
        if ((Usable == true)and(position<200)){ return true }
        else{ return false}
    }
    override fun describe():String{

        val Carburant = moteur.getCarburantRestant()
        val text = "type: $type\n" + "QRcode: $QRcode\n" + "Distance: $position m\n" +
                "Capacite: $Capacite L\n" + "Carburant Restant: ${Carburant.toInt()} L"
        return text
    }





}