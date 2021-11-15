package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson3IterativeFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", Lesson3IterativeFibonacci())
        testingSystems.runTests()
    }
}