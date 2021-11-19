package solutions.lesson3.fibo

import api.Task
import java.math.BigInteger

//  сложность алгоритма линейная
class IterativeFibonacci : Task {
    override fun run(data: List<String>): String {
        if (data.size != 1) {
            throw IllegalArgumentException()
        }

        return fibo(data[0].toInt()).toString()
    }

    private fun fibo(i: Int): BigInteger {
        if (i == 0 || i == 1) {
            return i.toBigInteger()
        }

        var f0: BigInteger = BigInteger.ZERO
        var f1 = BigInteger.ONE
        var result = BigInteger.ZERO

        for (j in 2..i) {
            result = f0 + f1
            f0 = f1
            f1 = result
        }

        return result
    }
}