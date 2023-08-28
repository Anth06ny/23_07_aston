package com.example.a23_07_aston

import com.google.gson.annotations.SerializedName
import java.util.Random



/* -------------------------------- */
// Mexicanfood
/* -------------------------------- */

data class MexicanFoodBean(
    val difficulty: String,
    val id: String,
    val image: String,
    val title: String
)

data class MexicanFoodDetailBean(
    val description: String,
    val difficulty: String,
    val id: String,
    val image: String,
    val ingredients: List<String>,
    val method: List<Method>,
    val portion: String,
    val time: String,
    val title: String
)

data class Method(
    @SerializedName("Step 1")
    val step1: String,
    @SerializedName("Step 2")
    val step2: String?,
    @SerializedName("Step 3")
    val step3: String?,
    @SerializedName("Step 4")
    val step4: String?,
    )

/* -------------------------------- */
// API Weather
/* -------------------------------- */

data class WeatherBean(var main: TempBean, var wind: WindBean, var name: String, var toto: String)
data class TempBean(var temp: Double)
data class WindBean(var speed: Double)


/* -------------------------------- */
// Exo
/* -------------------------------- */

class PlaneBean(name: String) {
    var id = name.hashCode()

    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }

}

class PrintRandomIntBean(var max: Int) {
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

class HouseBean(width: Int, length: Int, var color: String) {
    var area = width * length

    fun print() = println("La maison $color fait ${area}m²")
}

data class CarBean(var marque: String, var model: String?) {
    var color = ""
}

fun main() {
    var car = CarBean("seat", "leon")

}