package solutions.lesson6

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class InsertionSortWithBinarySearchTest {

    private val insertionSortWithBinarySearch = InsertionSortWithBinarySearch()


    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", insertionSortWithBinarySearch)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runDig3its() {
        val testingSystems = TestingSystems("6/1.digits", insertionSortWithBinarySearch)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", insertionSortWithBinarySearch)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", insertionSortWithBinarySearch)
        runWithTimeout(testingSystems)
    }
}