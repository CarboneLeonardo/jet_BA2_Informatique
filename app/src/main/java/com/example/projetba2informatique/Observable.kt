package com.example.projetba2informatique

interface Observable {
    val observers : ArrayList<Observer>
    val vehicules : ArrayList<Observer>
    fun add(observer: Observer) {
        observers.add(observer)
    }
    fun remove(observer: Observer) {
        observers.remove(observer)
    }
    fun hasUpdated(){
        observers.forEach{ if(it.Update() == true){vehicules.add(it)} }
    }

}
