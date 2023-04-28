package com.example.projetba2informatique

import android.widget.TextView

class Account {
    companion object {
        private val Prixcarburant = 2
        fun debit(numero:Double,CR:Double,CC:Double):Double{
            var solde = numero
            if (CR < 0){ solde -= Prixcarburant *(CR+CC) }
            else{ solde = Prixcarburant *CC }
            return  solde
        }
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