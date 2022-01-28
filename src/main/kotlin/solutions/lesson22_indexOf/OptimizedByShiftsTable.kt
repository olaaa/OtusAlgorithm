package solutions.lesson22_indexOf

import org.junit.jupiter.api.Assertions

class OptimizedByShiftsTable {
    /**
     * Проверка с конца шаблона. ТАК КАК последний символ будет сравниваться size - 1 раз, а первый только один
     * Если символ в шаблоне отсутствует, то сдвиг на длину шаблона, иначе -- на один шаг
     * В лучшем случае сложность t / p
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

//            решение о сдвиге принимается по последнему символу в шаблоне
            t = t + shifts[text[t + pattern.size - 1].code]
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
    val result = OptimizedByShiftsTable().indexOf("stronxstrxngstring".toCharArray(), "string".toCharArray())
    Assertions.assertEquals(12, result)
}