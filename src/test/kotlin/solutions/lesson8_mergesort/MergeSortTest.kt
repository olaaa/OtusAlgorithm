package solutions.lesson8_mergesort

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class MergeSortTest {

    private val sort = MergeSort()

    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", sort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", sort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", sort)
        runWithTimeout(testingSystems)
    }

    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", sort)
        runWithTimeout(testingSystems)
    }
}