package solutions.lesson6

import api.Task
import util.swap

// берется очередной сырой элемент и помещается в отсоритрованную часть. Эта часть нельзя возвращать клиенту,
// так как часть остортирована не относительно всего массива, а только барьера
// Элементы через границу не перелетают
class InsertionSortWithSwap : Task {
    override fun run(data: List<String>): String {
        val array = data.map { it.toInt() }.toTypedArray<Int>()
        val n = array.size
        for (barrier in 1..n - 1) {
            var location = barrier
            while (location > 0 && array[location - 1] > array[location]) { //  мелкого вперед
                swap(array, location - 1, location)
                location = location - 1  //  бежим к началу массива
            }
        }
        return array.contentDeepToString()
    }
}