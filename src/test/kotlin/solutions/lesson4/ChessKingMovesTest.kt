package solutions.lesson4

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class ChessKingMovesTest {

    @Test
    fun run() {
        val testingSystems = TestingSystems("4/1.Bitboard - Король", ChessKingMoves())
        testingSystems.runTests()
    }
}