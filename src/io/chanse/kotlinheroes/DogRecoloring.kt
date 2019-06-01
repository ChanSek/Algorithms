package io.chanse.kotlinheroes

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val puppies = reader.nextInt()
    if (puppies == 1) println("Yes")
    else {
        val colors = reader.next()
        val counts = IntArray(26)
        colors.forEach {
            val index = it - 'a'
            ++counts[index]
            if (counts[index] == 2) {
                println("Yes")
                return
            }
        }
        println("No")
    }
}
