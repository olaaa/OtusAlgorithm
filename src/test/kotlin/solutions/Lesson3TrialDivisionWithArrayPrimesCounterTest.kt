package solutions

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson3TrialDivisionWithArrayPrimesCounterTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/5.Primes", Lesson3TrialDivisionWithArrayPrimesCounter())
        testingSystems.runTests()
    }
}