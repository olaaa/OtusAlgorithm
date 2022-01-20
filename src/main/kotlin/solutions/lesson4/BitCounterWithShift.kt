package solutions.lesson4

class BitCounterWithShift : IBitCounter {
    override fun populationCounter(source: ULong): Int {
        var counter = 0
        var source = source

        while (source != 0uL) {
            if ((source and 1uL) == 1uL) {
                counter++
            }

            source = source shr 1
        }

        return counter
    }
}

fun main() {
    check(BitCounterWithShift().populationCounter(ULong.MAX_VALUE) == 64)
    check(BitCounterWithShift().populationCounter(ULong.MIN_VALUE) == 0)
}