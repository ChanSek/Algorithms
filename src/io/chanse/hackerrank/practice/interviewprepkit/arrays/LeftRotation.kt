package io.chanse.hackerrank.practice.interviewprepkit.arrays

import java.util.*

// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val arrSize = a.size
    val diff = arrSize - d
    val output = Array(arrSize) { 0 }
    a.forEachIndexed { index, i ->
        output[(index + diff) % arrSize] = i
    }
    return output
}

fun main() {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()
    val d = nd[1].trim().toInt()
    val a = scan.nextLine()
        .split(" ")
        .map{ it.trim().toInt() }
        .toTypedArray()

    val result = rotLeft(a, d)
    println(result.joinToString(" "))
}
