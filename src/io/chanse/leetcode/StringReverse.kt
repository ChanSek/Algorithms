package io.chanse.leetcode

class StringReverse {
    fun reverseString(s: CharArray): CharArray {
        var i = 0
        var j = s.size - 1
        while (i < j) {
            val temp = s[i]
            s[i++] = s[j]
            s[j--] = temp
        }
        return s
    }
}

fun main() {
    val string = "hello".toCharArray()
    println("Before - ${string.contentToString()}")
    val output = StringReverse().reverseString(string)
    println("After - ${output.contentToString()}")
}
