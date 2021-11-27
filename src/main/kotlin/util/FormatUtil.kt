package util

fun convertInputToArray(data: List<String>) =
    data[1].filterNot { it == ' ' }.map { Integer.valueOf(it.toString()) }.toTypedArray()
