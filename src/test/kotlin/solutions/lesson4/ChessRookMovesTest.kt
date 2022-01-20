package solutions.lesson4

import helpers.TestingSystems
import org.junit.jupiter.api.Test

internal class ChessRookMovesTest {

    @Test
    fun getBitboardMoves() {
        val testingSystems = TestingSystems("4/3.Bitboard - Ладья", ChessRookMoves())
        testingSystems.runTests()
    }
}