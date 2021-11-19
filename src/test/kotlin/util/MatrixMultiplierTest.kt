package util

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class MatrixMultiplierTest {

    @Test
    fun multiply() {
        val array1: Array<DoubleArray> =
            arrayOf(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(3.0, 2.0, 1.0), doubleArrayOf(4.0, 5.0, 6.0))
        val array2: Array<DoubleArray> =
            arrayOf(doubleArrayOf(7.0, 8.0, 9.0), doubleArrayOf(1.0, 3.0, 2.0), doubleArrayOf(2.0, 3.0, 4.0))
        val expect: Array<DoubleArray> = arrayOf(
            doubleArrayOf(15.0, 23.0, 25.0),
            doubleArrayOf(25.0, 33.0, 35.0),
            doubleArrayOf(45.0, 65.0, 70.0)
        )
        val result = MatrixMultiplier().multiply(array1, array2)
        assertContentEquals(expect[0], result[0])
        assertContentEquals(expect[1], result[1])
        assertContentEquals(expect[2], result[2])
    }
}