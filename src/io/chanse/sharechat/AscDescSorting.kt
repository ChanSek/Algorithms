package io.chanse.sharechat

import java.util.Arrays

/**
 * Sorting should be as follows:
 * input: arr = [A1, A2, A3, A4, ....., AN]
 * output: sort in such a way that:
 *          A1 >= A2 <= A3 >= A4 <= A5 >= .....
 */
fun main() {
    val arr = arrayOf(10, 2, 19, 78, 46, 109, 5, 28, 1092)
    for (i in 0..arr.size - 2) {
        if (i.isEven()) {
            if (arr[i] < arr[i + 1]) {
                arr.swap(i, i + 1)
            }
        } else {
            if (arr[i] > arr[i + 1]) {
                arr.swap(i, i + 1)
            }
        }
    }
    println(Arrays.toString(arr))
}

fun Int.isEven() = this % 2 == 0

fun <T> Array<T>.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}
