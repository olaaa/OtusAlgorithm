package solutions.lesson6

import helpers.TestingSystems
import helpers.runWithTimeout
import org.junit.jupiter.api.Test

internal class ShellSortTest {

    private val shellSort = ShellSort()


    @Test
    fun runRandom() {
        val testingSystems = TestingSystems("6/0.random", shellSort)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runDigits() {
        val testingSystems = TestingSystems("6/1.digits", shellSort)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runSorted() {
        val testingSystems = TestingSystems("6/2.sorted", shellSort)
        runWithTimeout(testingSystems)
    }


    @Test
    fun runRevers() {
        val testingSystems = TestingSystems("6/3.revers", shellSort)
        runWithTimeout(testingSystems)
    }
}