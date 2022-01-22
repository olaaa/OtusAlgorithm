package solutions.lesson8_mergesort

import api.Task
import org.junit.jupiter.api.Assertions
import util.convertInputToArray
import util.swap

class QuickSort : Task {
    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    fun sort(array: IntArray) {
        if (array.size == 0) {
            return
        }

        sort(array, 0, array.size - 1)
    }

    /*
    Массив разделяется на две части. Правая -- все элементы меньше или равно опорного элемента,
    слева -- больше
     */
    private fun sort(array: IntArray, l: Int, r: Int) {
        check(l >= 0)
        check(r >= 0)

        check(l <= r)
        if (l == r) {
            return
        }

        val m = split(array, l, r)

        sort(array, l, m)
        check(r >= m + 1)
        sort(array, m + 1, r)
    }

    private fun split(array: IntArray, l: Int, r: Int, pivotIndex: Int = r): Int {
        check(l <= r)
        check(l >= 0)
        check(r >= 0)

        if (l == r) {
            throw IllegalArgumentException()
        }

        val pivot = array[pivotIndex]
        var i = l
        var j = r

        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                i++
            }

            while (i <= j && array[j] > pivot && i <= j) {
                j--
            }

            while (i <= j && array[i] > pivot && array[j] <= pivot) {
                swap(array, i, j)
                i++
                j--
            }
        }

        val m = j
//        случай, когда опорный элемент был в конце массива и оказался с самым большим значением в массиве, и поэтому разделитель остался на том же месте.
        if (m == r) {
            return r - 1
        }

        check(m < r)
        return m
    }
}

fun main() {
    var array: IntArray = IntArray(4).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
    }

    val result = QuickSort()

    result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(4).apply {
            this[0] = 1
            this[1] = 2
            this[2] = 3
            this[3] = 7
        },
        array
    )

    array = IntArray(1).apply {
        this[0] = 3
    }

    result.sort(array)
    Assertions.assertArrayEquals(
        IntArray(1).apply {
            this[0] = 3
        },
        array
    )

    array = IntArray(0)
    result.sort(array)
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
    result.sort(array)
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

