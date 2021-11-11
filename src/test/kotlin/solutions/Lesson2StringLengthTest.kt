package solutions

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson2StringLengthTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("2/0.String", Lesson2LuckyTickets())
        testingSystems.runTests()
    }
}