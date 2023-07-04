package com.example.a23_07_aston

import java.util.Random

fun main() {

   var house = HouseBean(10, 20, "bleu")
//    house.print()
    house.area = 18
//    var randomPrint = PrintRandomIntBean()
//    randomPrint.max = 18

    val plane = PlaneBean("Toto")
    println("${plane.name} : ${plane.id}")
    plane.name = "bob"
    println("${plane.name} : ${plane.id}")

}

class PlaneBean(name: String){
    var id = name.hashCode()

    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }

}

class PrintRandomIntBean(var max : Int) {
    private val random = Random()

    init {
        println("init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructor")
        println(random.nextInt(max))
    }
}

class HouseBean( width : Int,  length : Int, var color : String ){
    var area = width * length

    fun print() = println("La maison $color fait ${area}m²")
}

data class CarBean(var marque: String, var model: String?) {
    var color = ""
}