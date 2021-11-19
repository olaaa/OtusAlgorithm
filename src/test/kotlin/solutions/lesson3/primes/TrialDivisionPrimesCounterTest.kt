package solutions.lesson3.primes

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class TrialDivisionPrimesCounterTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("3/5.Primes", TrialDivisionPrimesCounter())
        testingSystems.runTests()
    }
}