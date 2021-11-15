package solutions.lesson3

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson3TrialDivisionPrimesCounterTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/5.Primes", Lesson3TrialDivisionPrimesCounter())
        testingSystems.runTests()
    }
}