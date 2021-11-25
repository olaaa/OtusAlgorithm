package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class AdaptiveBubbleSortTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("6/IntegerArray", AdaptiveBubbleSort())
        testingSystems.runTests()
    }

    @Test
    fun `test adaptivity flag`() {
        val adaptiveBubbleSort = AdaptiveBubbleSort()
        val sortedArray = Array<Int>(10) { it }
        adaptiveBubbleSort.sort(sortedArray)
    }
}