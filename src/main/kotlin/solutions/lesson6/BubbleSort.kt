package solutions.lesson6

import api.Task

class BubbleSort : Task {
    override fun run(data: List<String>): String {
        val array = data.map { it.toInt() }.toTypedArray<Int>()
        sort(array)
        return array.contentDeepToString()
    }

    private fun sort(array: Array<Int>) {
        for (barrier in 0 until array.size - 1) {
            for (index in 0 until array.size - barrier - 1) {
                if (array[index] > array[index + 1]) { // из-за index + 1 в условии цикла -1, чтобы бы не выйти за границу массива
                    swap(array, index, index + 1)
                }
            }
        }
    }

    private fun swap(array: Array<Int>, i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }
}