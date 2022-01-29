package solutions.lesson22_indexOf

import org.junit.jupiter.api.Assertions

class BoyerMooreHorspool {
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
//        последний символ не участвует в цикле
        for (i in 0 until pattern.size - 1 ) {
//  если в шаблоне символ повторяется, то в итоге запишется наименьшее значение, так как массив в обратную сторону
            shifts[pattern[i].code] = pattern.size - 1 - i
        }

        return shifts
    }
}

fun main() {
    val haystack = ".KOLOLOKOLOKOLOKOL"
    val needle = "KOLOKOL"
    val result = BoyerMooreHorspool().indexOf(haystack.toCharArray(), needle.toCharArray())
    Assertions.assertEquals(haystack.indexOf(needle), result)
}