package search

import java.lang.IllegalStateException

/**
 * First increasing and then decreasing elements, find the max value
 * 10, 20, 30, 40, 50, 5, 3, 1
 *
 * Case 1 - 1st increasing, then decreasing
 * Case 2 - Only increasing
 *
 * 1 - Both "mid - 1" and "mid + 1" element is smaller than "mid"
 * 2 - If "mid - 1" < "mid" and "mid + 1" > "mid", then move right
 * 3 - If "mid - 1" > "mid" and "mid + 1" < "mid", then move left
 */
private fun findMax(arr: IntArray, low: Int = 0, high: Int = arr.size - 1): Int {
    val mid = (low + high) / 2

    if (low == high) return arr[low]
    if (mid == arr.size - 1 || mid == 0) return arr[mid]
    if (high - low == 1) return arr[low].coerceAtLeast(arr[high])

    return when {
        arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1] -> findMax(arr, mid, high)
        arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1] -> findMax(arr, low, mid)
        arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1] -> arr[mid]
        else -> throw IllegalStateException("Should not happen")
    }
}

private fun testFindMax() {
    println("Max - ${findMax(intArrayOf(10, 20, 30, 40, 50, 5, 3, 1))}")
    println("Max - ${findMax(intArrayOf(5, 10, 20, 30, 40, 50, 3, 1))}")
    println("Max - ${findMax(intArrayOf(1, 3, 5, 10, 20, 30, 40, 50))}")
    println("Max - ${findMax(intArrayOf(1, 3, 5, 10, 20, 30, 40, 50, 40))}")
    println("Max - ${findMax(intArrayOf(1, 3, 5, 10, 20, 30, 40, 50, 40, 30, 10))}")
    println("Max - ${findMax(intArrayOf(50, 40, 30, 20, 10, 5, 3, 1))}")
}

/**
 * Rotated array, find the min value
 * 10, 20, 30, 40, 50, 1, 3, 5
 * 50, 1, 3, 5, 10, 20, 30, 40
 */
private fun findMin(arr: IntArray, low: Int = 0, high: Int = arr.size - 1): Int {
    if (low == high) return arr[low]
    if (high - low == 1) return arr[low].coerceAtMost(arr[high])

    val mid = (low + high) / 2
    if (mid == arr.size - 1 || mid == 0) return arr[mid]

    return when {
        arr[mid] > arr[low] && arr[mid] > arr[high] -> findMin(arr, mid, high)
        arr[mid] < arr[low] && arr[mid] < arr[high] -> findMin(arr, low, mid)
        arr[mid] > arr[low] && arr[mid] < arr[high] -> findMin(arr, low, mid)
        else -> throw IllegalStateException("Should not happen")
    }
}

private fun testFindMin() {
    println("Min - ${findMin(intArrayOf(7, 8, 9, 10, 11, 1, 2, 3))}")
    println("Min - ${findMin(intArrayOf(3, 7, 8, 9, 10, 11, 1, 2))}")
    println("Min - ${findMin(intArrayOf(2, 3, 7, 8, 9, 10, 11, 1))}")
    println("Min - ${findMin(intArrayOf(1, 2, 3, 7, 8, 9, 10, 11))}")
    println("Min - ${findMin(intArrayOf(11, 1, 2, 3, 7, 8, 9, 10))}")
    println("Min - ${findMin(intArrayOf(10, 11, 1, 2, 3, 7, 8, 9))}")
    println("Min - ${findMin(intArrayOf(8, 9, 10, 11, 1, 2, 3, 7))}")

    println("Min - ${findMin(intArrayOf(8, 9, 10, 11, 12, 1, 2, 3, 7))}")
    println("Min - ${findMin(intArrayOf(7, 8, 9, 10, 11, 12, 1, 2, 3))}")
    println("Min - ${findMin(intArrayOf(3, 7, 8, 9, 10, 11, 12, 1, 2))}")
    println("Min - ${findMin(intArrayOf(2, 3, 7, 8, 9, 10, 11, 12, 1))}")
    println("Min - ${findMin(intArrayOf(12, 1, 2, 3, 7, 8, 9, 10, 11))}")
    println("Min - ${findMin(intArrayOf(11, 12, 1, 2, 3, 7, 8, 9, 10))}")
}

fun main() {
    testFindMax()
    testFindMin()
}
