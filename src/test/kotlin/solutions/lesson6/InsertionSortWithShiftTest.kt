package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

internal class InsertionSortWithShiftTest {

    private val insertionSortWithShift = InsertionSortWithShift()

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", insertionSortWithShift)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", insertionSortWithShift)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", insertionSortWithShift)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", insertionSortWithShift)
        testingSystems.runTests()
    }
}