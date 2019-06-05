package io.chanse.hackerrank.practice.interviewprepkit.warmupchallenges

import java.util.*

fun repeatedString(s: String, n: Long): Long {
    val len = s.length
    val times = n / len
    val remainder = n % len
    var count: Long = s.countA().toLong()
    count *= times
    count += s.countA(remainder.toInt())
    return count
}

fun String.countA(end: Int = this.length): Int {
    var count = 0
    for (i in 0 until end) {
        if (this[i] == 'a') ++count
    }
    return count
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()
    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)
    println(result)
}
