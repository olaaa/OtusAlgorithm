package solutions.lesson6

import api.Task
import util.convertInputToArray

class ShellSort : Task {
    override fun run(data: List<String>): String {
        val array: IntArray = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    private fun sort(array: IntArray) {
        var gap = array.size / 2
        while (gap > 0) {
            var i = 0
            while (i + gap < array.size) {
                var j = i + gap
                val current = array[j]
//  этот цикл выполнится 0 или 1 раз, поэтому в строчке array[j] = current выполнится либо обмен,
//  либо переприсовится собственное значение
                while (j - gap >= 0 && array[j - gap] > current) {
                    array[j] = array[j - gap]
                    j = j - gap
                }
                array[j] = current
                i++
            }
            gap = gap / 2
        }
    }
}