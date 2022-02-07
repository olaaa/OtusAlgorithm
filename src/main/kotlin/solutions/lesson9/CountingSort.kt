package solutions.lesson9

import api.Task
import org.junit.jupiter.api.Assertions
import util.convertInputToArray

class CountingSort : Task {
    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        val result = sort(array)
        return result.joinToString(separator = " ")
    }

    fun sort(array: IntArray): IntArray {
        if (array.size <= 1) {
            return array
        }

        val maxValue = getMaxValue(array)
        val count = IntArray(maxValue + 1)
        val output = IntArray(array.size)
//        заполнить каунт. индекс равен значению в сорце
        for (i in 0 until array.size) {
            val value = array[i]
            count[value] = count[value] + 1
        }
//        сквозное суммирование
        for (i in 1 until count.size) {
            count[i] = count[i] + count[i - 1]
        }

        for (i in output.size - 1 downTo 0) {
            val value = array[i]
            val position = count[value] - 1
            count[value] = position
            output[position] = value
        }

        return output
    }
}

fun main() {
    var array: IntArray = IntArray(5).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
        this[4] = 0
    }

    val result = CountingSort()

    array = result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(5).apply {
            this[0] = 0
            this[0 + 1] = 1
            this[1 + 1] = 2
            this[2 + 1] = 3
            this[3 + 1] = 7
        },
        array
    )

    array = IntArray(1).apply {
        this[0] = 3
    }

    array = result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(1).apply {
            this[0] = 3
        },
        array
    )

    array = IntArray(0)
    array = result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(0),
        array
    )

    array = IntArray(7).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
        this[4] = 6
        this[5] = 4
        this[6] = 0
    }
    array = result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(7).apply {
            this[0] = 0
            this[1] = 1
            this[2] = 2
            this[3] = 3
            this[4] = 4
            this[5] = 6
            this[6] = 7
        },
        array
    )
}