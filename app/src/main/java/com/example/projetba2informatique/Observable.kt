package com.example.projetba2informatique

interface Observable {
    val observers : ArrayList<Observer>
    val vehicules : ArrayList<Vehicule>
    fun add(observer: Observer) {
        observers.add(observer)
    }
    fun remove_vehicule(observer: Observer) {
        vehicules.remove(observer)
    }
    fun add_vehicule(vehicule: Vehicule){
        vehicules.add(vehicule)
    }
    fun hasUpdated():ArrayList<Vehicule>{
        observers.forEach{ if(it.Update() == true){add_vehicule(it as Vehicule)} }
        return vehicules
    }

}
