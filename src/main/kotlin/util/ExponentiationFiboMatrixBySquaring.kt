package util

import java.math.BigDecimal

class ExponentiationFiboMatrixBySquaring {
    fun pow(base: Array<Array<BigDecimal>>, power: Int): Array<Array<BigDecimal>> {
        check(base.size == base[0].size)

        var currBase = base
        var currPower = power

        // нейтральная матрица для умножения
        var res = arrayOf(arrayOf(BigDecimal.ONE, BigDecimal.ZERO), arrayOf(BigDecimal.ZERO, BigDecimal.ONE))

        while (currPower > 1) {
            if (currPower % 2 == 1) { // когда в бинарной СС текущая позиция равна единице, то домножаем
                res = MatrixMultiplier().multiply(res, currBase)
            }

            currBase = MatrixMultiplier().multiply(currBase, currBase) // возведение в квадрат на каждой операции
            currPower /= 2
        }
        if (currPower > 0) { //деление степени завершено и power = 1. 1 % 2 = 1
            res = MatrixMultiplier().multiply(res, currBase)
        }

        return res
    }
}