package io.chanse.hackerrank.practice.interviewprepkit.arrays

import java.util.*

// https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var result = -63
    for (row in 0 until 4) {
        for (col in 0 until 4) {
            val temp = arr[row][col..col + 2].sum() +
                    arr[row + 1][col + 1] +
                    arr[row + 2][col..col + 2].sum()
            if (temp > result) result = temp
        }
    }
    return result
}

operator fun <T> Array<T>.get(range: IntRange) = sliceArray(range)

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }
    for (i in 0 until 6) {
        arr[i] = scan.nextLine()
            .split(" ")
            .map{ it.trim().toInt() }
            .toTypedArray()
    }

    val result = hourglassSum(arr)
    println(result)
}
