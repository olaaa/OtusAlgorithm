package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson3IterativeExponentiationTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/3.Power", Lesson3IterativeExponentiation())
        testingSystems.runTests()
    }
}