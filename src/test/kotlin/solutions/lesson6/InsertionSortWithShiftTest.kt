package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class InsertionSortWithShiftTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("6/IntegerArray", InsertionSortWithShift())
        testingSystems.runTests()
    }
}