package solutions.lesson19

import org.junit.jupiter.api.Assertions

//  http://graphonline.ru/en/?graph=TqRLyrHJkewANKka view graph
class ShortestPathInGraph {
    private val adjacencyVectors: Array<IntArray> = arrayOf(IntArray(2).apply {
        this[0] = 1
        this[1] = 2
    }, IntArray(3).apply {
        this[0] = 0
        this[1] = 3
        this[2] = 4
    }, IntArray(2).apply {
        this[0] = 0
        this[1] = 3
    }, IntArray(3).apply {
        this[0] = 1
        this[1] = 2
        this[2] = 4
    }, IntArray(2).apply {
        this[0] = 1
        this[1] = 3
    })
    private val weightVectors: Array<IntArray> = arrayOf(IntArray(2).apply {
        this[0] = 5
        this[1] = 2
    }, IntArray(3).apply {
        this[0] = 5
        this[1] = 7
        this[2] = 3
    }, IntArray(2).apply {
        this[0] = 2
        this[1] = 1
    }, IntArray(3).apply {
        this[0] = 7
        this[1] = 1
        this[2] = 2
    }, IntArray(2).apply {
        this[0] = 3
        this[1] = 2
    }

    )

    private val markedVertexValue: Int = -1

    fun dijkstra(): Array<Edge?> {
        val paths = Array<Edge?>(adjacencyVectors.size) { null }
        val maxDistance: Int = Int.MAX_VALUE / 2
        val marks = IntArray(adjacencyVectors.size) { maxDistance }
        marks[0] = 0
        paths[0] = Edge(0, 0, 0)

        for (i in 0..adjacencyVectors.size - 2) {
            val prevVertex: Int = marks.getMin()
            println("current vertex $prevVertex")

            for (targetVertexIndex in adjacencyVectors[prevVertex].indices) {
                val targetVertex = adjacencyVectors[prevVertex][targetVertexIndex]
                if (marks[targetVertex] == markedVertexValue) {
                    continue
                }

                val weightOfEdge = weightVectors[prevVertex][targetVertexIndex]
                if (marks[prevVertex] + weightOfEdge < marks[targetVertex]) {
                    marks[targetVertex] = marks[prevVertex] + weightOfEdge
                    paths[targetVertex] = Edge(prevVertex, targetVertex, marks[targetVertex])
//                    println("target vertex $targetVertex")
                }
            }

            // в котлиновском массиве примитивов нет опепации удаления, поэтому присваиваю значение,
            // которое запрещено для весов графа
            marks[prevVertex] = markedVertexValue
        }

        return paths
    }


    private fun IntArray.getMin(): Int {
        var min: Int = Int.MAX_VALUE
        var minIndex: Int = markedVertexValue
        for (i in 0 until this.size) {
            if ((this[i] < min) && (this[i] != markedVertexValue)) {
                min = this[i]
                minIndex = i
            }
        }

        return minIndex
    }
}

data class Edge(val previousVertex: Int, val currentVertex: Int, val mark: Int)

fun main() {
    val shortestPaths: Array<Edge?> = ShortestPathInGraph().dijkstra()
    Assertions.assertEquals(shortestPaths[0]!!.mark, 0)
    Assertions.assertEquals(shortestPaths[0]!!.previousVertex, 0)
    Assertions.assertEquals(shortestPaths[2]!!.mark, 2)
    Assertions.assertEquals(shortestPaths[2]!!.previousVertex, 0)
    Assertions.assertEquals(shortestPaths[3]!!.mark, 3)
    Assertions.assertEquals(shortestPaths[3]!!.previousVertex, 2)
    Assertions.assertEquals(shortestPaths[4]!!.mark, 5)
    Assertions.assertEquals(shortestPaths[4]!!.previousVertex, 3)
    Assertions.assertEquals(shortestPaths[1]!!.mark, 5)
    Assertions.assertEquals(shortestPaths[1]!!.previousVertex, 0)


    println(shortestPaths.contentDeepToString().replace(", Edge", "\nEdge"))
}
