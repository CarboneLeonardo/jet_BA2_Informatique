package com.example.projetba2informatique

interface Observable {
    val observers : ArrayList<Observer>
    fun add(observer: Observer) {
        observers.add(observer)
    }
    fun remove(observer: Observer) {
        observers.remove(observer)
    }
    fun hasUpdated(list:ArrayList<Vehicule>) {
        observers.forEach{
            it.Update()

        }
    }

}
