package util

import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*
import kotlin.io.path.Path

fun main() {
    val map = mapOf(0 to 10L, 1 to 100L, 2 to 1000L, 3 to 10_000L)
    val testFileNumber = 3
    val arraySize: Long = map[testFileNumber]!!

    createFiles(arraySize, testFileNumber)
}

private fun createFiles(arraySize: Long, testFileNumber: Int) {
    val ints = Random().ints(arraySize, 0, 100).toArray()
    val message: String = ints.joinToString(separator = "\n") { "$it" }

    val s: String =
        Paths.get("").toAbsolutePath().toString() + "/src/test/resources/6/IntegerArray/test.$testFileNumber.in"
    val fileS = File(s)
    if (fileS.exists().not()) {
        Files.createFile(Path(s))
    } else {
        Files.newBufferedWriter(Paths.get(s), StandardOpenOption.TRUNCATE_EXISTING)
    }

    val writer = FileWriter(s, false)
    writer.write(message)
    writer.flush()

    val s1: String =
        Paths.get("").toAbsolutePath().toString() + "/src/test/resources/6/IntegerArray/test.$testFileNumber.out"
    val fileOut = File(s1)
    if (fileOut.exists().not()) {
        Files.createFile(Path(s1))
    } else {
        Files.newBufferedWriter(Paths.get(s1), StandardOpenOption.TRUNCATE_EXISTING)
    }

    val writer1 = FileWriter(s1, false)
    writer1.write(ints.also { it.sort() }.toTypedArray().contentDeepToString())
    writer1.flush()
}