package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson3RecursiveFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", Lesson3RecursiveFibonacci())
        testingSystems.runTests()
    }
}