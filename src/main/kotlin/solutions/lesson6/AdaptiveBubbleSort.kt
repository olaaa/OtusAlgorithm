package solutions.lesson6

import api.Task
import util.convertInputToArray
import util.swap

class AdaptiveBubbleSort : Task {
    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    private fun sort(array: IntArray) {
        for (barrier in 0 until array.size - 1) {
            var swapped = false
            for (index in 0 until array.size - barrier - 1) {
                if (array[index] > array[index + 1]) { // из-за index + 1 в условии цикла -1, чтобы бы не выйти за границу массива
                    swap(array, index, index + 1)
                    swapped = true
                }
            }

            if (swapped.not()) {
                return
            }
        }
    }

}
