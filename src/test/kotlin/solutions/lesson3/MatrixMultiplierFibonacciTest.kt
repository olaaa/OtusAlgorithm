package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class MatrixMultiplierFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", MatrixMultiplierFibonacci())
        testingSystems.runTests()
    }
}