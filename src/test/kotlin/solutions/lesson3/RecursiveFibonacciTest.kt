package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class RecursiveFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", RecursiveFibonacci())
        testingSystems.runTests()
    }
}