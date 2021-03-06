package solutions.lesson6

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class InsertionSortWithShiftTest {

    private val insertionSortWithShift = InsertionSortWithShift()


    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", insertionSortWithShift)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", insertionSortWithShift)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", insertionSortWithShift)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", insertionSortWithShift)
        runWithTimeout(testingSystems)
    }
}