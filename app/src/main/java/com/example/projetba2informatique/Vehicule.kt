package com.example.projetba2informatique

import kotlin.math.roundToInt
import kotlin.random.Random

abstract class Vehicule : Observer {
    // Position= une valeur Random entre 1m et 1000m
    abstract val moteur : Moteur
    protected var Usable = true
    private var position = Random.nextInt(1,1000)

    abstract val QRcode :Int
    abstract val type : String
    abstract val Capacite : Int
    // Question importante !!!!!!!!!!
    // : Pq ne pas faire des méthodes générales et uniquement changer les valeurs des attributs dans les sous classes ???
    // Ex: "Update" est laissée comme ça dans "Vehicule", cependant on définit une valeur "PositionMax" que l'on rend "abstract"
    // (ou "PositionMax = 200")
    override fun Update():Boolean { // A voir si on change pas le nom de "Update" par "Scan".
        if((Usable == true)and(position<200)){return true}
        else{
            return false
        }
    }
    fun describe():String{
        val text:String
        val Carburant = moteur.getCarburantRestant()
        if (Carburant<=0.9){
            Usable = false
            text = "Ce vehicule n'a plus de carburant, veuillez selectionner un autre vehicule"
        }
        else{
            text = "type: $type\n" + "QRcode: $QRcode\n" + "Distance: $position m\n" +
                    "Capacite: $Capacite L\n" + "Carburant Restant: ${Carburant.roundToInt()} L"
        }
        return text
    }
    fun Usable(bool:Boolean){ Usable=bool}
    fun getUsability():Boolean{ return Usable}





}