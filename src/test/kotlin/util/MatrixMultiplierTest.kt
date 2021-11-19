package util

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertContentEquals

internal class MatrixMultiplierTest {

    @Test
    fun multiply() {
        val array1: Array<Array<BigDecimal>> =
            arrayOf(
                arrayOf(BigDecimal(1.0), BigDecimal(2.0), BigDecimal(3.0)),
                arrayOf(BigDecimal(3.0), BigDecimal(2.0), BigDecimal(1.0)),
                arrayOf(BigDecimal(4.0), BigDecimal(5.0), BigDecimal(6.0))
            )

        val array2: Array<Array<BigDecimal>> =
            arrayOf(
                arrayOf(BigDecimal(7.0), BigDecimal(8.0), BigDecimal(9.0)),
                arrayOf(BigDecimal(1.0), BigDecimal(3.0), BigDecimal(2.0)),
                arrayOf(
                    BigDecimal(2.0), BigDecimal(3.0), BigDecimal(4.0)
                )
            )
        val expect: Array<Array<BigDecimal>> = arrayOf(
            arrayOf(
                BigDecimal(15.0), BigDecimal(23.0), BigDecimal(25.0)
            ),
            arrayOf(
                BigDecimal(25.0), BigDecimal(33.0), BigDecimal(35.0)
            ),
            arrayOf(
                BigDecimal(45.0), BigDecimal(65.0), BigDecimal(70.0)
            )
        )
        val result = MatrixMultiplier().multiply(array1, array2)
        assertContentEquals(
            expect[0], result[0]
        )
        assertContentEquals(
            expect[1], result[1]
        )
        assertContentEquals(expect[2], result[2])
    }
}