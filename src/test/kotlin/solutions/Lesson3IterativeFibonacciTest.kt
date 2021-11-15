package solutions

import helpers.TestingSystems
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Lesson3IterativeFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", Lesson3IterativeFibonacci())
        testingSystems.runTests()
    }
}