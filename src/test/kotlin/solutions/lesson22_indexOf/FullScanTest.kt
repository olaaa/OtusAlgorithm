package solutions.lesson22_indexOf

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class FullScanTest {

    val path = "src${File.separator}test${File.separator}resources${File.separator}22${File.separator}warandpeace.txt"
    val file = File(path)
    val text = file.readText()

    val fullScan = FullScan()
    val needle = "During his stay at Bald Hills all the family dined together"
    val expect = text.indexOf(needle)

    @Test
    fun indexOf() {
        val start = System.currentTimeMillis()
        assertEquals(expect, fullScan.indexOf(text.toCharArray(), needle.toCharArray()))
        val stop = System.currentTimeMillis()
        println(stop - start)
    }
}