package solutions.lesson4

import api.Task

class ChessKingMoves : Task {
    /**
     * @param position -- позиция на доске в диапазоне [0; 63]
     * https://gekomad.github.io/Cinnamon/BitboardCalculator/ Layout 2
     */
    private fun getBitboardMoves(position: Int): Pair<Int, ULong> {
        if (position < 0 || position > 63) {
            throw IllegalArgumentException()
        }
//        Конвертировать номер клетки [0; 63] коня в ulong-значение битовой доски
        val bitPosition: ULong = 1uL shl position

        val noAMask: ULong = 0xfefefefefefefefeuL
        val noHMask: ULong = 0x7f7f7f7f7f7f7f7fuL
        val kingNoA = noAMask and bitPosition
        val kingNoH = noHMask and bitPosition
        val kingMoves: ULong =
            // ход вперед и влево  //ход вперед        // ход вперед и вправо
            (kingNoA shl 7) or (bitPosition shl 8) or (kingNoH shl 9) or
                    // ход влево        // ход вправо
                    (kingNoA shr 1) or (kingNoH shl 1) or
                    // ход назад и влево // ход назад          // ход назад и вправо
                    (kingNoA shr 9) or (bitPosition shr 8) or (kingNoH shr 7)

        return CacheBitCounter().populationCounter(kingMoves) to kingMoves
    }

    override fun run(data: List<String>): String {
        val position = data.first().toInt()
        val result = getBitboardMoves(position)
        return "${result.first}${System.lineSeparator()}${result.second}"
    }
}

fun main() {
    ChessRookMoves().getBitboardMoves(23)
}