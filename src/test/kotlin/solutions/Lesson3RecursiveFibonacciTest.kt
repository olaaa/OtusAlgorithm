package solutions

import helpers.TestingSystems
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Lesson3RecursiveFibonacciTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/4.Fibo", Lesson3RecursiveFibonacci())
        testingSystems.runTests()
    }
}