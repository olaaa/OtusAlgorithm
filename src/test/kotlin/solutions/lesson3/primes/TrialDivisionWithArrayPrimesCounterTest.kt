package solutions.lesson3.primes

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class TrialDivisionWithArrayPrimesCounterTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/5.Primes", TrialDivisionWithArrayPrimesCounter())
        testingSystems.runTests()
    }
}