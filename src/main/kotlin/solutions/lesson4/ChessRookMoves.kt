package solutions.lesson4

import api.Task

class ChessRookMoves : Task {
    /**
     * @param position -- позиция на доске в диапазоне [0; 63]
     * https://gekomad.github.io/Cinnamon/BitboardCalculator/ Layout 2
     */
    fun getBitboardMoves(position: Int): Pair<Int, ULong> {
        if (position < 0 || position > 63) {
            throw IllegalArgumentException()
        }
//        Конвертировать номер клетки [0; 63] коня в ulong-значение битовой доски
        val bitPosition: ULong = 1uL shl position
        bitPosition.toString(2).apply { println(this) }

//        ходы вперед
        var movesForwardMask: ULong = 0uL
        var previousPosition: ULong = bitPosition
        while (previousPosition != 0uL) {
            previousPosition = previousPosition shl 8
            movesForwardMask = previousPosition or movesForwardMask
        }

//        ходы назад
        var movesBackMask: ULong = 0uL
        var previousPosition1: ULong = bitPosition
        while (previousPosition1 != 0uL) {
            previousPosition1 = previousPosition1 shr 8
            movesBackMask = previousPosition1 or movesBackMask
        }

//        ходы вправо и влево
//        находим октет
        val octet: Int = position / 8
//        сгенерировать число, старший октет которого равен 255, все младшие биты -- нули, и вычесть текущую позицию
        val horizontalMoves: ULong = (0b1111_1111uL shl (octet * 8)) xor bitPosition
        val mask = movesBackMask or movesForwardMask or horizontalMoves
        return ResetingToZeroBitCounter().populationCounter(mask) to mask
    }

    override fun run(data: List<String>): String {
        val position = data.first().toInt()
        val result = getBitboardMoves(position)
        return "${result.first}${System.lineSeparator()}${result.second}"
    }
}

fun main() {
    ChessRookMoves().getBitboardMoves(23).also { println(it) }
}