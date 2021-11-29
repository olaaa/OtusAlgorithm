package util

fun swap(array: IntArray, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}
