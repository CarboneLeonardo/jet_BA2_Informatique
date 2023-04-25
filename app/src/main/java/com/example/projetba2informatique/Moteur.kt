package com.example.projetba2informatique

import kotlin.random.Random

class Moteur(capacite:Int,carburant:Double) {



    private var CarburantRestant = capacite * carburant
    private var CarburantConsome = capacite * Random.nextDouble(0.05,0.25)
    //private val instance_Account = Account.getInstance()


    fun consomer():Double {

                // Attributs: capacité totale du moteur et carburant restant dans celui-ci en pourcentage
                // But: simuler la consomation de carburant par le véhicule
                // Modus Operandi: On retire au carburant restant une valeur de fuel compris entre 5% et 25%

        CarburantRestant -= CarburantConsome
                // On utilise tout en "Double" car la seul fonction random qui convient pour des "floats"
                // où l'on peut choisir l'intervalle est le cas du type "Double".
        if (CarburantRestant<0){
            //instance_Account.debit(1000.toDouble(),CarburantRestant,CarburantConsome)
            CarburantConsome += CarburantRestant
            CarburantRestant= 0.0 // Empeche d'avoir des valeurs de carburant négatives
            println("le véhicule n'a plus de carburant")
        }
        else{
            //instance_Account.debit(1000.toDouble(),CarburantRestant,CarburantConsome)
            println("il reste $CarburantRestant du carburant")
        }
        return CarburantConsome
    }
    fun getCarburantRestant():Double{ return CarburantRestant}
}
