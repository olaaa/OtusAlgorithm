package util

// Операция умножения двух матриц выполнима только в том случае,
// если число столбцов в первом сомножителе равно числу строк во втором;
// в этом случае говорят, что матрицы согласованы.
class MatrixMultiplier { // умножение квадратных матриц
    fun multiply(firstMatrix: Array<DoubleArray>, secondMatrix: Array<DoubleArray>): Array<DoubleArray> {
        check(firstMatrix[0].size == secondMatrix.size)

        // строк столько же, сколько в первой матрице
        val result = Array(firstMatrix.size) {
            DoubleArray(
//                колонок столько же, сколько во второй
                secondMatrix[0].size
            )
        }
        for (row in result.indices) {
            for (col in 0 until result[row].size) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col)
            }
        }
        return result
    }

    private fun multiplyMatricesCell(
        firstMatrix: Array<DoubleArray>,
        secondMatrix: Array<DoubleArray>,
        row: Int,
        col: Int
    ): Double {
        var cell = 0.0
//        число столбцов в первом сомножителе равно числу строк во втором
        for (i in secondMatrix.indices) {
            cell += firstMatrix[row][i] * secondMatrix[i][col]
        }
        return cell
    }
}