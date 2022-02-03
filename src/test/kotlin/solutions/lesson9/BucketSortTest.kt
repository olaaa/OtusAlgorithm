package solutions.lesson9

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import solutions.lesson8_mergesort.MergeSort

internal class BucketSortTest {
    private val sort = BucketSort()

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