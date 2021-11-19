package util

import java.math.BigDecimal

// Операция умножения двух матриц выполнима только в том случае,
// если число столбцов в первом сомножителе равно числу строк во втором;
// в этом случае говорят, что матрицы согласованы.
class MatrixMultiplier { // умножение квадратных матриц
    fun multiply(
        firstMatrix: Array<Array<BigDecimal>>,
        secondMatrix: Array<Array<BigDecimal>>
    ): Array<Array<BigDecimal>> {
        check(firstMatrix[0].size == secondMatrix.size)

        // строк столько же, сколько в первой матрице
        val result = Array(firstMatrix.size) {
            Array<BigDecimal>(
//                колонок столько же, сколько во второй
                secondMatrix[0].size
            ) { BigDecimal.ZERO }
        }
        for (row in result.indices) {
            for (col in 0 until result[row].size) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col)
            }
        }
        return result
    }

    private fun multiplyMatricesCell(
        firstMatrix: Array<Array<BigDecimal>>,
        secondMatrix: Array<Array<BigDecimal>>,
        row: Int,
        col: Int
    ): BigDecimal {
        var cell = BigDecimal.ZERO
//        число столбцов в первом сомножителе равно числу строк во втором
        for (i in secondMatrix.indices) {
            cell += firstMatrix[row][i] * secondMatrix[i][col]
        }
        return cell
    }
}