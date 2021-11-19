package solutions.lesson3

import api.Task

class ExponentiationBySquaring : Task {
    override fun run(data: List<String>): String {
        if (data.size != 2) {
            throw IllegalArgumentException()
        }

        var base = data[0].toDouble()
        var power = data[1].toLong()
        var res = 1.0
        while (power > 1) {
            if (power % 2 == 1L) { // когда в бинарной СС текущая позиция равна единице, то домножаем
                res *= base
            }

            base *= base // возведение в квадрат на каждой операции
            power /= 2
        }
        if (power > 0) { //деление степени завершено и power = 1. 1 % 2 = 1
            res *= base
        }

        return res.toString()
    }
}