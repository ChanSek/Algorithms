package io.chanse.coursera.algo1

import java.util.*

class WeightedQuickUnion(private val arr: IntArray) {

    var height = 0

    fun connect(p: Int, q: Int) {
        val rootOfP = root(p)
        val heightOfP = height
        val rootOfQ = root(q)
        val heightOfQ = height
        if (heightOfP <= heightOfQ) arr[rootOfP] = rootOfQ
        else arr[rootOfQ] = rootOfP
    }

    fun isConnected(p: Int, q: Int) = root(p) == root(q)

    private fun root(i: Int): Int {
        var index = i
        height = 0
        while (index != arr[i]) {
            index = arr[i]
            height++
        }
        return index
    }
}

fun main() {
    val input = IntArray(10) { it }

    val qu = WeightedQuickUnion(input)
    qu.connect(1, 2)
    input.forEach {
        print(qu.isConnected(1, it).toString() + " ")
    }
    println()

    qu.connect(2, 1)
    input.forEach {
        print(qu.isConnected(1, it).toString() + " ")
    }
    println()

    qu.connect(1, 4)
    input.forEach {
        print(qu.isConnected(1, it).toString() + " ")
    }
    println()

    input.forEach {
        print(qu.isConnected(2, it).toString() + " ")
    }
    println()

    qu.connect(2, 1)
    input.forEach {
        print(qu.isConnected(1, it).toString() + " ")
    }
    println()

    qu.connect(0, 3)
    qu.connect(3, 5)
    qu.connect(3, 1)
    println(qu.isConnected(1, 2))
    println(qu.isConnected(2, 1))
    println(Arrays.toString(input))
}
