package com.example.testapp

class Movie (
    private val name: String,
    val duration: Int
        ){
    fun play():String{
        var mensaje =""
        for (i in 0 .. duration)
            mensaje += "Playing Movie $name \n"
        return mensaje
    }
}