package solutions.lesson8_mergesort

import api.Task
import org.junit.jupiter.api.Assertions
import util.convertInputToArray

class MergeSort: Task {
    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    fun sort(src: IntArray) {
        if (src.size == 0) {
            return
        }

        sort(src, 0, src.size - 1)
    }

    private fun sort(array: IntArray, l: Int, r: Int) {
        if (r - l == 0) {
            return
        }

        val m: Int = (l + r) / 2
        sort(array, l, m)
        sort(array, m + 1, r)
        merge(array, l, m, r)
    }

    private fun merge(array: IntArray, l: Int, m: Int, r: Int) {
        var i = l
        var j = m + 1
        var k = 0
        val tmpArray = IntArray(r - l + 1)

        while (k <= tmpArray.size) {
            if (i == m + 1 && j == r + 1) { // правая и левая части исчерпаны
                break
            } else if (i == m + 1) {
                tmpArray[k] = array[j]
                j++
            } else if (j == r + 1) {
                tmpArray[k] = array[i]
                i++
            } else if (array[i] <= array[j]) {
                tmpArray[k] = array[i]
                i++
            } else {
                tmpArray[k] = array[j]
                j++
            }

            k++
        }

        for (i in 0 until tmpArray.size) {
            array[i + l] = tmpArray[i]
        }
    }
}

fun main() {
    var array: IntArray = IntArray(4).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
    }

    val result = MergeSort()

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