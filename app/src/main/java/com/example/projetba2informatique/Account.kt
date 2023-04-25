package com.example.projetba2informatique

import android.widget.TextView

class Account private constructor() {

    private val Prixcarburant = 2

    companion object {
        @Volatile
        private var instance: Account? = null
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Account().also { instance = it }
            }
    }

    fun debit(numero:Double,CR:Double,CC:Double):Double{
        var solde = numero
        if (CR < 0){ solde -= Prixcarburant *(CR+CC) }
        else{ solde = Prixcarburant *CC }
        return  solde
    }
}

//class Account {
//    companion object{
//        val Prixcarburant = 2
//        fun debit(numero:Double,CR:Double,CC:Double):Double{
//            var solde = numero
//            if (CR < 0){ solde -= Prixcarburant*(CR+CC) }
//            else{ solde = Prixcarburant*CC }
//            return solde
//        }
//    }
//}