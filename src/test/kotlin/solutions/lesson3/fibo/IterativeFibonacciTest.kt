package solutions.lesson3.fibo

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class IterativeFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", IterativeFibonacci())
        testingSystems.runTests()
    }
}