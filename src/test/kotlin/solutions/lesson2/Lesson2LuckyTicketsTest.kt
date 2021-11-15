package solutions.lesson2

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class Lesson2LuckyTicketsTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("2/1.Tickets", Lesson2LuckyTickets())
        testingSystems.runTests()
    }
}