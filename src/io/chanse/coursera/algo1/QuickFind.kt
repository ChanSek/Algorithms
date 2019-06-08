package io.chanse.coursera.algo1

fun main() {
    val arr = IntArray(10) { it }
    val qf = QuickFind(arr)
    qf.connect(1, 2)
    arr.forEach {
        print(qf.isConnected(1, it).toString() + " ")
    }
    println()
    qf.connect(2, 1)
    arr.forEach {
        print(qf.isConnected(1, it).toString() + " ")
    }
    println()
    qf.connect(3, 8)
    arr.forEach {
        print(qf.isConnected(3, it).toString() + " ")
    }
    println()
    qf.connect(3, 1)
    arr.forEach {
        print(qf.isConnected(3, it).toString() + " ")
    }
    println()
    qf.connect(0, 9)
    arr.forEach {
        print(qf.isConnected(3, it).toString() + " ")
    }
    println()
    arr.forEach {
        print(qf.isConnected(0, it).toString() + " ")
    }
}

class QuickFind(private val arr: IntArray) {

    fun connect(p: Int, q: Int) {
        val pid = arr[p]
        val qid = arr[q]
        arr.forEachIndexed { index, i ->
            if (i == pid) arr[index] = qid
        }
    }

    fun isConnected(p: Int, q: Int) = arr[p] == arr[q]
}
