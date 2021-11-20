package solutions.lesson3.fibo

import api.Task
import java.math.BigDecimal
import java.math.RoundingMode

class GoldenRatioFibonacci : Task {
    private val fi = (1 + Math.sqrt(5.0)) / 2

    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        val n = data[0].toInt()
        if (n == 0 || n == 1) {
            return n.toString()
        }

//        val fibo = Math.round(fi.pow(n.toDouble()) / Math.sqrt(5.0))
        val pow: BigDecimal = BigDecimal(fi).pow(n)
        val fibo: BigDecimal = pow / BigDecimal(Math.sqrt(5.0)) + BigDecimal(0.5)

        val result = fibo.setScale(0, RoundingMode.FLOOR)
        return result.toString()
    }
}