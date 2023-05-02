package com.example.projetba2informatique

class Ecurie:Observable{
    override val observers:ArrayList<Observer> = ArrayList();
    override val vehicules:ArrayList<Vehicule> = ArrayList()
    var title = ""
        set(value) {
            field = value;
            hasUpdated();
        }
}








//var observers:List<Observer> = listOf()

//var x=0 // Représente le QRcode à voir comment on upload bien ça
//var observers = ArrayList<Observer>()
//fun add(observer: Observer) {
//    observers.add(observer)
//}
//fun remove(observer: Observer) {
//    observers.remove(observer)
//}
//fun hasUpdated() {
//    observers.forEach{
//        it.Update()
//    }
//}