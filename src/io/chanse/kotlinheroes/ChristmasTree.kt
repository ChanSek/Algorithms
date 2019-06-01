package io.chanse.kotlinheroes

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val yellow = reader.nextInt()
    val blue = reader.nextInt() - 1
    val red = reader.nextInt() - 2
    val temp = if (yellow > blue) blue else yellow
    val smallest = if (temp > red) red else temp
    println(smallest * 3 + 3)
}
