package com.example.projetba2informatique

class Account private constructor(Solde: Int) {
    private val Prixcarburant = 2
    private var solde = Solde.toDouble()

    companion object {

        @Volatile
        private var instance: Account? = null
        fun getInstance(argent:Int) =
            instance ?: synchronized(this) {
                instance ?: Account(argent).also { instance = it }
            }
    }
    fun debit(CarburantRestant:Double,CarburantConsome:Double):Float{
        if (CarburantRestant < 0){ solde -= Prixcarburant *(CarburantRestant+CarburantConsome) }
        else{ solde -= Prixcarburant*CarburantConsome }
        return  solde.toFloat()
    }
    fun RemainingSolde():Float{return solde.toFloat()}
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