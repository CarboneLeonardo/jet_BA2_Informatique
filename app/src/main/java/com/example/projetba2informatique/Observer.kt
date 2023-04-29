package com.example.projetba2informatique

interface Observer {

    val moteur : Moteur
    fun Update():Boolean
    fun describe():String
}