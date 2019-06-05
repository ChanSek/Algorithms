package io.chanse.hackerrank.practice.interviewprepkit.warmupchallenges

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    val s = scan.nextLine()

    val result = countingValleys(n, s)
    println(result)
}

fun countingValleys(n: Int, s: String): Int {
    var insideValley = false
    var stepsFromSeaLevel = 0
    var valleyCount = 0
    s.forEach {
        when (it) {
            'U' -> {
                stepsFromSeaLevel++
                if (stepsFromSeaLevel == 0 && insideValley) {
                    valleyCount++
                    insideValley = false
                }
            }
            'D' -> {
                stepsFromSeaLevel--
                insideValley = true
            }
        }
    }
    return valleyCount
}
