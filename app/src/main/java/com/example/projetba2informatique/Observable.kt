package com.example.projetba2informatique

interface Observable {
    val observers : ArrayList<Observer>
    val vehicules : ArrayList<Observer>
    fun add(observer: Observer) {
        observers.add(observer)
    }
    fun remove_vehicule(observer: Observer) {
        vehicules.remove(observer)
    }
    fun add_vehicule(observer: Observer){
        vehicules.add(observer)
    }
    fun hasUpdated():ArrayList<Observer>{
        observers.forEach{ if(it.Update() == true){add_vehicule(it)} }
        return vehicules
    }

}
