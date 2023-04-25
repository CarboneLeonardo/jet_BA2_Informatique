package com.example.projetba2informatique

import kotlin.random.Random

abstract class Vehicule() : Observer {
    // Position= une valeur Random entre 1m et 1000m


    private var Usable = true
    private var position = Random.nextInt(1,1000)

    private val Capacite = Random.nextInt(1,100)
    private val Carburant = Random.nextDouble(0.3,0.9)

    private val moteur : Moteur = Moteur(Capacite,Carburant)



    override fun Update() { // A voir si on change pas le nom de "Update" par "Scan".
    if((Usable == true)and(position<200)){
        println("c'est faux,ce que j'écris")
        // Doit être changé dans les classes "Trotinette" et "vehicule"
    }
    else{
        println("pas dispo")
        }
    }
    fun describe():ArrayList<String>{
    // 1) donnes les imforamtions suivantes :
        // val info = moteur.consomer()
        val Carburant = moteur.getCarburantRestant()
        var text = arrayOf("$type","$QRcode","$position","$Capacite","$Carburant")

    }





}