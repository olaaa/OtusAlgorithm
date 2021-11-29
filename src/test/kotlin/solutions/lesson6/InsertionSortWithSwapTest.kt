package solutions.lesson6

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class InsertionSortWithSwapTest {

    private val insertionSortWithSwap = InsertionSortWithSwap()


    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", insertionSortWithSwap)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", insertionSortWithSwap)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", insertionSortWithSwap)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", insertionSortWithSwap)
        runWithTimeout(testingSystems)
    }
}