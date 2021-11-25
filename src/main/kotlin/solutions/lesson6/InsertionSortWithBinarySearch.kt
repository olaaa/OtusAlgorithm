package solutions.lesson6

import api.Task
import java.util.*

// берется очередной сырой элемент и помещается в отсоритрованную часть. Эта часть нельзя возвращать клиенту,
// так как часть остортирована не относительно всего массива, а только барьера
// Элементы через границу не перелетают
class InsertionSortWithBinarySearch : Task {
    override fun run(data: List<String>): String {
        val array = data.map { it.toInt() }.toTypedArray<Int>()
        val n = array.size
        var position = 0
        for (barrier in 1..n - 1) {
//           param toIndex -- exclusive
            val newElement = array[barrier]
            val pos =
                Arrays.binarySearch(array, 0, barrier, array[barrier]) // работает по отсортированному массиву

            if (pos < 0) {
                position = Math.abs(pos) - 1
            } else {
                // в отсортированной части есть такой же элемент
                position = pos + 1
            }

            if (position == barrier) {
                continue
            }

            System.arraycopy(array, position, array, position + 1, barrier - position)
            array[position] = newElement
        }
        return array.contentDeepToString()
    }
}