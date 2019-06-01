package io.chanse.kotlinheroes

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val queries = reader.nextInt()
    val output = IntArray(queries)
    for (i in 0 until queries) {
        val point = reader.nextInt()
        output[i] = getCount(point)
    }
    output.forEach {
        println(it)
    }
}

fun getCount(point: Int) = if (point % 7 == 0) point / 7 else (point / 7) + 1
