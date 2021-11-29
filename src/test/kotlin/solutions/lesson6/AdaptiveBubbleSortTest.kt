package solutions.lesson6

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class AdaptiveBubbleSortTest {

    private val adaptiveBubbleSort = AdaptiveBubbleSort()

    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", adaptiveBubbleSort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", adaptiveBubbleSort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", adaptiveBubbleSort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", adaptiveBubbleSort)
        runWithTimeout(testingSystems)
    }
}