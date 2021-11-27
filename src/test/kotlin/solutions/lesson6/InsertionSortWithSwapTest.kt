package solutions.lesson6

import helpers.TestingSystems
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

internal class InsertionSortWithSwapTest {

    private val insertionSortWithSwap = InsertionSortWithSwap()

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", insertionSortWithSwap)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", insertionSortWithSwap)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", insertionSortWithSwap)
        testingSystems.runTests()
    }

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", insertionSortWithSwap)
        testingSystems.runTests()
    }
}