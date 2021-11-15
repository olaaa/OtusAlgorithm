package helpers

import api.Task
import org.junit.jupiter.api.Test
import java.io.File

class TestingSystems(
    private val pathToLesson: String,
    private val task: Task
) {
    @Test
    fun runTests() {
        val path = "src/test/resources/"

        var currFileNumber = 0
        while (true) {
            val prefixFile = "$path$pathToLesson\\test.$currFileNumber."
            val inFile = File("${prefixFile}in")
            val outFile = File("${prefixFile}out")
            if (inFile.exists().not() || outFile.exists().not()) {
                break
            }

            val start = System.nanoTime()
            val result = runTest(inFile, outFile)
            println("${(System.nanoTime() - start) / 1_000} microseconds Test #$currFileNumber - $result")
            currFileNumber++
        }
    }

    private fun runTest(inFile: File, outFile: File): Boolean {
        val lineSeparator = inFile.readLines()
        val actual = task.run(lineSeparator)
        val except = outFile.readText().trim()
        return except == actual
    }
}