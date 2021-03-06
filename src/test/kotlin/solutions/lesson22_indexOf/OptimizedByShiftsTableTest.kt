package solutions.lesson22_indexOf

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class OptimizedByShiftsTableTest {
    val path = "src${File.separator}test${File.separator}resources${File.separator}22${File.separator}warandpeace.txt"
    val file = File(path)
    val text = file.readText()

    val needle = text.substring(text.length - 1_000, text.length - 100)
    val expect = text.indexOf(needle)
    val needle2 = text.substring(text.length - 20_000, text.length - 100)
    val expect2 = text.indexOf(needle2)
    val needle3 = "stifling"
    val expect3 = text.indexOf(needle3)

    @Test
    fun indexOf() {
        val start = System.currentTimeMillis()
        assertEquals(expect, OptimizedByShiftsTable().indexOf(text.toCharArray(), needle.toCharArray()))
        val stop = System.currentTimeMillis()
        println(stop - start)
    }

    @Test
    fun indexOfLargePattern() {
        val start = System.currentTimeMillis()
        assertEquals(expect2, OptimizedByShiftsTable().indexOf(text.toCharArray(), needle2.toCharArray()))
        val stop = System.currentTimeMillis()
        println(stop - start)
    }

    @Test
    fun indexOfTinyPattern() {
        val start = System.currentTimeMillis()
        assertEquals(expect3, OptimizedByShiftsTable().indexOf(text.toCharArray(), needle3.toCharArray()))
        val stop = System.currentTimeMillis()
        println(stop - start)
    }
}