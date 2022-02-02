package helpers

import api.Task
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.time.Duration

class TestingSystems(
    private val pathToLesson: String,
    private val task: Task
) {
    @Test
    fun runTests() {
        val path = "src${File.separator}test${File.separator}resources${File.separator}"

        var currFileNumber = 0
        while (true) {
            val prefixFile = "$path$pathToLesson${File.separator}test.$currFileNumber."
            val inFile = File("${prefixFile}in")
            val outFile = File("${prefixFile}out")
            if (inFile.exists().not() || outFile.exists().not()) {
                break
            }

            val start = System.nanoTime()
            val result = runTest(inFile, outFile)
            assert(result)
            println("${(System.nanoTime() - start) / 1_000_000}ms Test #$currFileNumber - $result")
            currFileNumber++
        }
    }

    private fun runTest(inFile: File, outFile: File): Boolean {
        val lineSeparator: List<String> = inFile.readLines()
        val actual = task.run(lineSeparator)
        val except = outFile.readText().trim()
        if (except.contains('.') && except.toDoubleOrNull() is Double && actual.toDoubleOrNull() is Double) {
            return Math.abs(except.toDouble() - actual.toDouble()) < 0.0001
        }
        return except == actual
    }
}

fun runWithTimeout(testingSystems: TestingSystems) {
    Assertions.assertTimeoutPreemptively(Duration.ofMillis(3 * 60 * 1000)) {
        testingSystems.runTests()
    }
}
