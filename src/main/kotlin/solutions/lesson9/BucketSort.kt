package solutions.lesson9

import api.Task
import org.junit.jupiter.api.Assertions
import util.convertInputToArray

/**
 * Только неотрицательные числа
 */
class BucketSort : Task {
    class Map(val size: Int) {
        val table = Array<Node?>(size) { null }

        //    если значение value уже хранится, то добавляемый value нужно положить последним в списке,
//    чтобы в процессе добавления/удаления сохранялся порядок, то есть сохранилась стабиьлность.
//    Чтение происходит от минимального элемента и от начала связанного списка
        fun put(index: Int, value: Int) {
            if (table[index] == null) {
                table[index] = Node(value)
            } else {
//            нужно проитерироваться до конца списка
                var node: Node? = table[index]!!

// добавляемое значение меньше текущего. такая ситуация возможна, когда добавлять нужно первым элементом списка.
                if (node!!.value > value) {
                    val newNode = Node(value, node.next)
                    table[index] = newNode
                    newNode.next = node
                    return
                }

                while (node != null) {
//  когда следующий элемент в списке имеет такое же значение, как и добавляемое, но следующее отличаетяся
// добавляемый элемент нужно положить в конце среди одинаковых
                    if (node.value == value
                        && node.next?.value != value
                    ) {
                        val newNode = Node(value, node.next)
                        node.next = newNode
                        break
                    }
// добавляемое значение больше текущего, а следующего либо нет, либо оно больше добавляемого
                    else if (node.value < value
                        && (node.next == null || node.next!!.value > value)
                    ) {
                        val newNode = Node(value, node.next)
                        node.next = newNode
                        break
                    } else {
                        node = node.next
                    }
                }
            }
        }

        data class Node(val value: Int, var next: Node? = null)
    }

    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        sort(array)
        return array.joinToString(separator = " ")
    }

    fun sort(array: IntArray) {
        if (array.size <= 1) {
            return
        }

        val max = getMaxValue(array)
        val bucketIndex = { a: Int ->
//  сначала делим, чтобы избежать переполнение int. a.toDouble() необходимо, чтобы деление не давало 0
            val result = ((a.toDouble() / (max + 1)) * array.size).toInt()
            result
        }

        val bucketIndexOfMaxValue = bucketIndex(max)
        val mymap = Map(bucketIndexOfMaxValue + 1)

        for (i in 0 until array.size) {
            val index = bucketIndex(array[i])
            mymap.put(index, array[i])
        }

        var j = 0
        // iterator
        for (i in 0 until mymap.table.size) {
            if (mymap.table[i] == null) {
                continue
            }

            var node = mymap.table[i]
            while (node != null) {
                array[j] = node.value
                j++
                node = node.next
            }
        }
    }

}

fun getMaxValue(array: IntArray): Int {
    var maxValue = 0

    for (i in 0 until array.size) {
        if (array[i] > maxValue) {
            maxValue = array[i]
        }
    }

    return maxValue
}

fun main() {
    var array: IntArray = IntArray(4).apply {
        this[0] = 3
        this[1] = 2
        this[2] = 1
        this[3] = 7
    }

    val result = BucketSort()

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