package solutions.lesson3

import api.Task
import util.ExponentiationFiboMatrixBySquaring
import java.math.BigDecimal

class MatrixMultiplierFibonacci : Task {
    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        return fibo(data[0].toInt()).toString()
    }

    private fun fibo(number: Int): BigDecimal {
        if (number == 0 || number == 1) {
            return number.toBigDecimal()
        }

        val resMatrix = ExponentiationFiboMatrixBySquaring().pow(
            arrayOf(arrayOf(BigDecimal.ONE, BigDecimal.ONE), arrayOf(BigDecimal.ONE, BigDecimal.ZERO)), number - 1
        )

        return resMatrix[0][0]
    }
}