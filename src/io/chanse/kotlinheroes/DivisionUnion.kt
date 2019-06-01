package io.chanse.kotlinheroes

import java.lang.StringBuilder
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val queries = reader.nextInt()
    val output = Array(queries) { StringBuilder() }
    for (i in 0 until queries) {
        val segments = reader.nextInt()
        val group1 = mutableListOf<Point>()
        val group2 = mutableListOf<Point>()
        group1.add(Point(reader.nextInt(), reader.nextInt()))
        output[i].append(1)
        for (j in 1 until segments) {
            val segment = Point(reader.nextInt(), reader.nextInt())
            if (group1.contains(segment)) {
                group1.add(segment)
                output[i].append(' ').append(1)
            } else {
                group2.add(segment)
                output[i].append(' ').append(2)
            }
        }
        if (group2.isEmpty()) {
            output[i].clear()
            output[i].append(-1)
        }
    }
    output.forEach { println(it) }
}

class Point(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        return other is Point && (x == other.x || y == other.y)
    }
}
