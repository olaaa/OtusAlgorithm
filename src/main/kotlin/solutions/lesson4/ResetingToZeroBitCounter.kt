package solutions.lesson4

/**
 * сложность равна количеству единиц в исходном числе
 * https://habr.com/ru/company/otus/blog/476510/
 */
class ResetingToZeroBitCounter : IBitCounter {
    override fun populationCounter(source: ULong): Int {
        var counter = 0
        var source = source
        while (source != 0uL) {
// младшие нули превращаются в 1, младшая единица -- в 0
            val minus1 = source - 1uL
            //сбрасывается в ноль самая правая единица
            source = source and minus1
            counter++
        }

        return counter
    }
}

fun main() {
    check(ResetingToZeroBitCounter().populationCounter(ULong.MAX_VALUE) == 64)
    check(ResetingToZeroBitCounter().populationCounter(ULong.MIN_VALUE) == 0)
}