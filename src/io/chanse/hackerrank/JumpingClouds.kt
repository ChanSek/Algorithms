package io.chanse.hackerrank

import java.lang.IndexOutOfBoundsException
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    val c = scan.nextLine().split(" ")
        .map{ it.trim().toInt() }
        .toTypedArray()

    val result = jumpingOnClouds(c)
    println(result)
}

fun jumpingOnClouds(c: Array<Int>): Int {
    var jumpCounts = 0
    var i = 0
    val size = c.size
    try {
        while (i < size) {
            if (c[i + 2] == 0) {
                i += 2
                jumpCounts++
            } else {
                i++
                jumpCounts++
            }
        }
    } catch (e: IndexOutOfBoundsException) {
        if (i == size - 2) jumpCounts++
    }
    return jumpCounts
}
