package solutions.lesson4

import api.Task
import kotlin.math.absoluteValue

class ChessRookMoves : Task {
    /**
     * @param position -- позиция на доске в диапазоне [0; 63]
     * https://gekomad.github.io/Cinnamon/BitboardCalculator/ Layout 2
     */
    fun getBitboardMoves(position: Int): Pair<Int, ULong> {
        if (position < 0 || position > 63) {
            throw IllegalArgumentException()
        }

//      Конвертировать номер клетки [0; 63] коня в ulong-значение битовой доски
        val bitPosition: ULong = 1uL shl position

//        ходы по горизонтали
//        находим октет
        val octet: Int = position / 8
//        сгенерировать число, старший октет которого равен 255, все младшие биты -- нули, и вычесть текущую позицию
        val horizontalMoves: ULong = (0b1111_1111uL shl (octet * 8)) xor bitPosition

//        ходы по вертикали
//        берем большее значение октета и вычитаем позицию, так находим положение единички в октете
        val bitOctetPosition = (octet * 8 - position).absoluteValue
        val verticalMaskOfA = 0x101010101010101uL
        val verticalMoves: ULong = (verticalMaskOfA shl bitOctetPosition) xor bitPosition
        val mask = horizontalMoves or verticalMoves
        return ResetingToZeroBitCounter().populationCounter(mask) to mask
    }

    override fun run(data: List<String>): String {
        val position = data.first().toInt()
        val result = getBitboardMoves(position)
        return "${result.first}${System.lineSeparator()}${result.second}"
    }
}

fun main() {
    ChessRookMoves().getBitboardMoves(3).also { println(it) }
}