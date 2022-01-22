package solutions.lesson8_mergesort

import api.Task
import org.junit.jupiter.api.Assertions
import util.convertInputToArray
import util.swap

class ImprovedQuickSort : Task {
    private var comparisonCounter: Long = 0

    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    fun sort(array: IntArray) {
        if (array.size == 0) {
            return
        }
        comparisonCounter = 0

        sort(array, 0, array.size - 1)
        println("Comparison count $comparisonCounter")
    }

    /*
    Массив разделяется на две части. Правая -- все элементы меньше или равно опорного элемента,
    слева -- больше
     */
    private fun sort(array: IntArray, l: Int, r: Int) {
        check(l >= 0)

        if (r == -1 && l == 0) {
            return
        }

        if (r + 1 == l) {
            return
        }

        if (l == r) {
            return
        }

        val a = split(array, l, r)

        sort(array, l, a - 1)
        sort(array, a + 1, r)
    }

    private fun split(array: IntArray, l: Int, r: Int): Int {
        check(l < r)
        check(l >= 0)
        check(r >= 0)

        val pivot = array[r]
        var a = l - 1 // последний элемент в первой (левой) части

//        так как опорный элемент -- это последний элемент в массиве, он окажется старшим в первой части, поэтому
//        необходимо сортировать до и после него. Его местоположение не изменится
        for (i in l..r) {
            if (array[i] <= pivot) {
                ++a
                if (a != i) {
                    swap(array, a, i)
                }
            }
        }

        return a
    }
}

fun main() {
    var array: IntArray = IntArray(4).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
    }

    val result = ImprovedQuickSort()

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

