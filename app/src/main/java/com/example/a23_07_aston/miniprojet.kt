package com.example.a23_07_aston

fun main() {
//    var html  = RequestUtils.sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")
//    println(html)

//    var data = RequestUtils.loadWeather("Nice")
//    println("Il fait ${data.main.temp}° à ${data.name} avec un vent de ${data.wind.speed} m/s")

//    var data2: Array<MexicanFoodBean> = APIMexicanFoodUtils.loadMexicanFood()
//    var detail: MexicanFoodDetailBean = APIMexicanFoodUtils.loadMexicanFoodDetail(data2[0].id)
//
//    println("Recette : ${data2[0].title} : ")
//    println(detail)

    for(i in 1..5 step 2) {
        println(i)
    }

    repeat(5) {
        println("toto$it")
    }

}