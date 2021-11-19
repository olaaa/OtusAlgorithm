package solutions.lesson3.power

import api.Task

// линейная сложность
class IterativeExponentiation : Task {
    override fun run(data: List<String>): String {
        if (data.size != 2) {
            throw IllegalArgumentException()
        }

        val a = data[0].toDouble()
        val pow = data[1].toLong()
        var result = 1.0 // любое число в нулевой степени это 1
        for (i in 0 until pow) {
            result = result * a
        }

        return result.toString()
    }
}