package solutions

import api.Task
import kotlin.math.pow

class Lesson2LuckyTickets : Task {
    override fun run(data: List<String>): String {
        return luckyTickets(data[0].toInt()).toString()
    }

    private fun getNextArr(prevArr: List<Long>): ArrayList<Long> { // функция для построения следующего массива из предыдущего
        val newLen = prevArr.size + 9 // длинна следующего массива будет больше на 9
        val result = arrayListOf<Long>() // заготовка результата

        for (i in 0 until newLen) { // количество билетов для каждой суммы
            var q = 0L // заготовка нового значения
            for (j in 0 until 10) { // итерация по первым цифрам правой части билета
                if (i - j in prevArr.indices) // ...если они существуют в предыдущем массиве
                    q += prevArr[i - j] // добавляем
            }
            result.add(q)
        }
        return result
    }

    private fun luckyTickets(num: Int): Long { // собственно сам счетчик
        var arr = mutableListOf<Long>() // первый массив
        var result: Long = 0 // то, что мы вернем
        for (i in 0..9) {
            arr.add(1)
        } // впихиваем в первый массив 10 единиц

        for (i in 0 until (num - 1)) { // если N = 1, то в тело цикла не должны попасть
            arr = getNextArr(arr) // строим следующие массивы
        }
        arr.forEach { result += it.toDouble().pow(2.0).toLong() } // сводим квадраты значений в получившемся массиве
        return result
    }
}