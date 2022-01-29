package solutions.lesson22_indexOf.draft

import java.util.*


object BM {
    private const val ASIZE = 255
    private val bad_character_shift = IntArray(ASIZE)
    private lateinit var good_suffix_shift: IntArray
    private lateinit var suff: IntArray
    private fun pre_bad_character_shift(pattern: String) {
        val m = pattern.length
        for (i in 0 until ASIZE) {
            bad_character_shift[i] = m
        }
        for (i in 0 until m - 1) {
            bad_character_shift[pattern[i].code] = m - i - 1
        }
    }

    private fun pre_suff(pattern: String) {
        var j: Int
        val m = pattern.length
        suff = IntArray(m)
        suff[m - 1] = m
        for (i in m - 2 downTo 0) {
            j = 0
            while (j <= i && pattern[i - j] == pattern[m - j - 1]) {
                j++
            }
            suff[i] = j
        }
    }

    private fun pre_good_suffix_shift(pattern: String) {
        var j = 0
        val m = pattern.length
        good_suffix_shift = IntArray(m)
        pre_suff(pattern)
        for (i in 0 until m) {
            good_suffix_shift[i] = m
        }
        j = 0
        for (i in m - 1 downTo 0) {
            if (suff[i] == i + 1) {
                while (j < m - 1 - i) {
                    good_suffix_shift[j] = m - 1 - i
                    ++j
                }
            }
        }
        for (i in 0..m - 2) {
            good_suffix_shift[m - 1 - suff[i]] = m - 1 - i
        }
    }

    private fun BM_alg(text: String, pattern: String) {
        var i: Int
        var j: Int
        val m = pattern.length
        val n = text.length
        pre_bad_character_shift(pattern)
        pre_good_suffix_shift(pattern)
        j = 0
        while (j <= n - m) {
            i = m - 1
            while (i >= 0 && pattern[i] == text[i + j]) {
                --i
            }
            j += if (i < 0) {
                print("$j ")
                good_suffix_shift[0]
            } else Math.max(good_suffix_shift[i], bad_character_shift[text[i + j].code] - m + 1 + i)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val pattern: String
        val text: String
        val scanner = Scanner(System.`in`)
        println("Podaj tekst")
        text = "GCATCGCAGAGAGTATACAGTACG"
        println("Podaj wzorzec")
        pattern = "GCAGAGAG"
        BM_alg(text, pattern)
    }
}