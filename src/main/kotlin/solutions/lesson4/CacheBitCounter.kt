package solutions.lesson4

/**
 * сложность равна количеству единиц в исходном числе
 * https://habr.com/ru/company/otus/blog/476510/
 */
class CacheBitCounter : IBitCounter {
    private val cache = IntArray(256)

    init {
        populateCache()
    }

    private fun populateCache() {
        val bitCounter = ResetingToZeroBitCounter()
// значение массива -- это количество единиц, которое содержится в двоичном представлении 8-битного числа [0; 255]
        for (i in cache.indices) {
            cache[i] = bitCounter.populationCounter(i.toULong())
        }
    }

    override fun populationCounter(source: ULong): Int {
//         сдвиг от нуля до 56 с шагом 8
        var counter = 0
//        количество бит в ULong в 8 раз больше, чем в элементе кэша
        for (i in 0 until 64 step 8) {
//      чтобы взять октет, нужно сместить его к правому краю и применить маску & 255
            counter += cache[((source shr i) and 255uL).toInt()]
        }

        return counter
    }
}

fun main() {
    check(CacheBitCounter().populationCounter(ULong.MAX_VALUE) == 64)
    check(CacheBitCounter().populationCounter(Integer.parseInt("00010001", 2).toULong()) == 2)
    check(CacheBitCounter().populationCounter(ULong.MIN_VALUE) == 0)
}