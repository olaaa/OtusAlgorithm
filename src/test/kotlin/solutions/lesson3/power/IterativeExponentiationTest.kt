package solutions.lesson3.power

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class IterativeExponentiationTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/3.Power", IterativeExponentiation())
        testingSystems.runTests()
    }
}