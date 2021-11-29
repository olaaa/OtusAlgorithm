package util

fun convertInputToArray(data: List<String>): IntArray =
    data[1].split(' ').map { it.toInt() }.toIntArray()
