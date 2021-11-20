package solutions.lesson3.fibo

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class GoldenRatioFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", GoldenRatioFibonacci())
        testingSystems.runTests()
    }
}