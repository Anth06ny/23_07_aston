package com.example.a23_07_aston

import kotlin.concurrent.thread


fun main()  {
    var total = boulangerie(3, nbB = 2)
    println("total=$total")
}

fun boulangerie(nbCr :Int = 0, nbS : Int=0, nbB : Int=0)
        = nbCr * PRICE_CROISSANT + PRICE_BAG * nbB + PRICE_SAND * nbS


fun min(a:Int, b:Int, c:Int) : Int
    = if (a < b && a < c)  a else if(b < a && b < c) b else  c

fun myprint(str:String)  = println("#$str#")
fun pair(c:Int) = c%2 ==0



