package solutions.lesson4

class ChessKingMoves {
    /**
     * @param position -- позиция на доске в диапазоне [0; 63]
     * https://gekomad.github.io/Cinnamon/BitboardCalculator/ Layout 2
     */
    fun getKingBitboardMoves(position: Int): ULong {
        if (position < 0 || position > 63) {
            throw IllegalArgumentException()
        }
//        Конвертировать номер клетки коня в ulong-значение битовой доски
        val bitPosition: ULong = 1uL shl position
        println(bitPosition.toString(2))

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

        println(kingMoves.toString(2))
        return kingMoves
    }
}

fun main() {
    ChessKingMoves().getKingBitboardMoves(23)
}