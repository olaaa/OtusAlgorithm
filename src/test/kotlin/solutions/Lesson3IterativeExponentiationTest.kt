package solutions

import helpers.TestingSystems
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Lesson3IterativeExponentiationTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/3.Power", Lesson3IterativeExponentiation())
        testingSystems.runTests()
    }
}