package io.chanse.coursera.algo1

class QuickUnion(private val arr: IntArray) {

    fun connect(p: Int, q: Int) {
        val root = root(p)
        arr[root] = root(q)
    }

    fun isConnected(p: Int, q: Int) = root(p) == root(q)

    private fun root(p: Int): Int {
        var index = p
        while (arr[index] != index) {
            index = arr[index]
        }
        return index
    }
}

fun main() {
    val input = IntArray(10) { it }

    val qu = QuickUnion(input)
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
}
