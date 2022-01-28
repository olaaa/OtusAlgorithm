package solutions.lesson22_indexOf

import org.junit.jupiter.api.Assertions

/**
Complexitity t * p -- quadratic
 */
class FullScan {
    fun indexOf(text: CharArray, pattern: CharArray): Int {
        // размер сдвига для каждого символа
        var t = 0

        while (t <= text.size - pattern.size) {
            var p = 0
            while (p < pattern.size && pattern[p] == text[t + p]) {
                p++
            }
            if (p == pattern.size) {
                return t
            }

            t++
        }

        return -1
    }
}

fun main() {
    val result = FullScan().indexOf("strongstring".toCharArray(), "string".toCharArray())
    Assertions.assertEquals(6, result)
}