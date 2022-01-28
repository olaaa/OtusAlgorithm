package solutions.lesson17_DFS_BFS

import java.util.*

class BreadthFirstSearch {
    fun search(): MutableList<Int> {
        val used = BooleanArray(adjacencyVectors.size)
        val result = mutableListOf<Int>()

        // LIFO
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)

        while (queue.isNotEmpty()) {
            val currVertex = queue.poll()
            used[currVertex] = true // помечается при обработке
            result.add(currVertex)
            println("current vertex $currVertex")

            for (i in 0 until adjacencyVectors[currVertex].size) {
                val adjacentVertex = adjacencyVectors[currVertex][i]
                if (
                    !queue.contains(adjacentVertex) &&
                    !used[adjacentVertex]
                ) {
                    println("   enqueue $adjacentVertex")
                    queue.add(adjacentVertex)
                }
            }
        }

        return result
    }

    // optimized
    fun searchFromWiki(): MutableList<Int> {
        val used = BooleanArray(adjacencyVectors.size)
        val result = mutableListOf<Int>()

        // LIFO
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        used[0] = true

        while (queue.isNotEmpty()) {
            val currVertex = queue.poll()
            println("current vertex $currVertex")
            result.add(currVertex)
            for (i in 0 until adjacencyVectors[currVertex].size) {
                val adjacentVertex = adjacencyVectors[currVertex][i]
                if (
//                    !queue.contains(adjacentVertex) &&
                    !used[adjacentVertex]
                ) {
                    println("   enqueue $adjacentVertex")
                    used[adjacentVertex] = true
                    queue.add(adjacentVertex)
                }
            }
        }

        return result
    }
}

fun main() {
    val breadthFirstSearch = BreadthFirstSearch()
//    breadthFirstSearch.search().apply { println(toString()) }
    breadthFirstSearch.searchFromWiki().apply { println(toString()) }
}