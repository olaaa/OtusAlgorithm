package solutions.lesson22_indexOf

import org.junit.jupiter.api.Assertions

class OptimizedByShiftsTable {
    /**
     * Проверка с конца шаблона. Если символ в шаблоне отсутствует, то сдвиг на длину шаблона
     */
    fun indexOf(text: CharArray, pattern: CharArray): Int {
        val shifts: IntArray = creteShifts(pattern)

        var t = 0

        while (t <= text.size - pattern.size) {
            var p = pattern.size - 1
            while (p >= 0 && pattern[p] == text[t + p]) {
                p--
            }

            if (p == -1) {
                return t
            }

            t = t + shifts[text[t + p].code]
        }

        return -1
    }

    private fun creteShifts(pattern: CharArray): IntArray {
//        по умолчанию размер шаблона
        val shifts = IntArray(128) { pattern.size }
//        для тех символов, которые есть в шаблоне, сдвиг на 1
        for (i in 0 until pattern.size) {
            shifts[pattern[i].code] = 1
        }

        return shifts
    }
}

fun main() {
    val result = OptimizedByShiftsTable().indexOf("stronxstring".toCharArray(), "string".toCharArray())
    Assertions.assertEquals(6, result)
}