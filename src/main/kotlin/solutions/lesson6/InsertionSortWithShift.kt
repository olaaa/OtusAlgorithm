package solutions.lesson6

import api.Task
import util.convertInputToArray

// берется очередной сырой элемент и помещается в отсоритрованную часть. Эта часть нельзя возвращать клиенту,
// так как часть остортирована не относительно всего массива, а только барьера
// Элементы через границу не перелетают
class InsertionSortWithShift : Task {
    override fun run(data: List<String>): String {
        val array = convertInputToArray(data)
        val n = array.size
        for (barrier in 1..n - 1) {
            val newElement = array[barrier]
            var location = barrier - 1
            while (location >= 0 && array[location] > newElement) { //  мелкого вперед
                array[location + 1] = array[location] // "сдвиг" вправо
                location = location - 1  //  бежим к началу массива
            }
            array[location + 1] = newElement // добаляем единичку, так как в конце цикла while ее вычли
        }
        return array.joinToString(separator = " ")
    }
}