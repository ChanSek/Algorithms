package io.chanse.hackerrank

import java.util.*

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var counter = 0
    val temp = IntArray(100)
    ar.forEach {
        if (temp[it - 1] == 0) {
            temp[it - 1] = 1
        } else {
            counter++
            temp[it - 1] = 0
        }
    }
    return counter
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine()
        .split(" ")
        .map{ it.trim().toInt() }
        .toTypedArray()

    val result = sockMerchant(n, ar)
    println(result)
}
