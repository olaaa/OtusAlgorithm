package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class AdaptiveBubbleSortTest {

    private val adaptiveBubbleSort = AdaptiveBubbleSort()

    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", adaptiveBubbleSort)
        testingSystems.runTests()
    }

    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", adaptiveBubbleSort)
        testingSystems.runTests()
    }

    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", adaptiveBubbleSort)
        testingSystems.runTests()
    }

    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", adaptiveBubbleSort)
        testingSystems.runTests()
    }

    @Test
    fun `test adaptivity flag`() {
        val adaptiveBubbleSort = adaptiveBubbleSort
        val sortedArray = Array<Int>(10) { it }
        adaptiveBubbleSort.sort(sortedArray)
    }
}