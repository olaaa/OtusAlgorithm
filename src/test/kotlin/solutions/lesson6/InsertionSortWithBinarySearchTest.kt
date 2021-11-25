package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class InsertionSortWithBinarySearchTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("6/IntegerArray", InsertionSortWithBinarySearch())
        testingSystems.runTests()
    }
}