package io.chanse.kotlinheroes

import java.lang.StringBuilder
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val queries = reader.nextInt()
    val output = arrayOfNulls<String>(queries)
    for (i in 0 until queries) {
        val str = reader.next()
        when {
            str.allCharactersSame() -> output[i] = "-1"
            str.isPalindrome().not() -> output[i] = str
            else -> output[i] = str.rearrange()
        }
    }
    output.forEach { println(it) }
}

fun String.isPalindrome(): Boolean {
    val size = length
    for (i in 0 until size / 2) {
        if (this[i] != this[size - i - 1]) return false
    }
    return true
}

fun String.allCharactersSame(): Boolean {
    for (i in 0 until length - 1) {
        if (this[i] != this[i + 1]) return false
    }
    return true
}

fun String.rearrange(): String {
    val middle = length / 2
    for (i in middle until length - 1) {
        if (this[i] != this[i + 1]) {
            val builder = StringBuilder(this)
            val temp = builder[i]
            builder[i] = builder[i + 1]
            builder[i + 1] = temp
            return builder.toString()
        }
    }
    return this
}
