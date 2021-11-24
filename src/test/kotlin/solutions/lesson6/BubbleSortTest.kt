package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class BubbleSortTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("6/IntegerArray", BubbleSort())
        testingSystems.runTests()
    }
}