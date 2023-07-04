package com.example.a23_07_aston

fun main() {
//    var html  = RequestUtils.sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")
//    println(html)

    var data = RequestUtils.loadWeather("Nice")
    println("Il fait ${data.main.temp}° à ${data.name} avec un vent de ${data.wind.speed} m/s")

}