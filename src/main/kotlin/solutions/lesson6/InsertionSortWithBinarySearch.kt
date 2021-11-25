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
        var position: Int
        for (barrier in 1..n - 1) {
//           param toIndex -- exclusive
            val newElement = array[barrier]
            val pos =
                Arrays.binarySearch(array, 0, barrier, array[barrier]) // работает по отсортированному массиву

//          предполагаемое место вставки  (-(insertion point) - 1), поэтому число по модулю надо увеличить на 1
//           либо эквивалентный Элемент уже существует в отсортированной части, тогда newElement ставим после такового
            position = Math.abs(pos + 1)


            // если position == barrier, то arraycopy будет копировать ноль элементов
            System.arraycopy(array, position, array, position + 1, barrier - position)
            array[position] = newElement
        }
        return array.contentDeepToString()
    }
}