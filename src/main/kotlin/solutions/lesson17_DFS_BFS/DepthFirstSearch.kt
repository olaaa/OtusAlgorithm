package solutions.lesson17_DFS_BFS

import java.util.*

val adjacencyVectors: Array<IntArray> = arrayOf(IntArray(2).apply {
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
},
    // 5
    IntArray(1).apply {
        this[0] = 6
    },
    // 6
    IntArray(1).apply {
        this[0] = 5
    })

class DepthFirstSearch {
    fun searchRecursively(): MutableList<Int> {
        val used = BooleanArray(adjacencyVectors.size)
        val result = mutableListOf<Int>()
        searchRecursively(0, used, result)
        return result
    }

    private fun searchRecursively(currVertex: Int, used: BooleanArray, result: MutableList<Int>) {
        if (used[currVertex]) {
            return
        }

        used[currVertex] = true
        result.add(currVertex)

        for (adjacentV in adjacencyVectors[currVertex]) {
            searchRecursively(adjacentV, used, result)
        }
    }

    //    порядок обхода инвесрный. Благодаря стэку итерируемся не с младшей соседней вершины, а со старшей
    fun search(): MutableList<Int> {
        /*
        деление вершин на развёрнутые и не развёрнутые необходимо для произвольного графа (так как в нём могут быть циклы).
         Для дерева эта операция не нужна, так как каждая вершина будет выбрана один-единственный раз.
         */
        val used = BooleanArray(adjacencyVectors.size)
        val result = mutableListOf<Int>()

        // LIFO
        val stack = Stack<Int>()
        stack.push(0)

        while (stack.isNotEmpty()) {
            val currVertex = stack.pop()
            used[currVertex] = true
            result.add(currVertex)
            println("current vertex $currVertex")

            for (i in 0 until adjacencyVectors[currVertex].size) {
                val adjacentVertex = adjacencyVectors[currVertex][i]
                if (!stack.contains(adjacentVertex) && !used[adjacentVertex]) {
                    stack.push(adjacentVertex)
                    println("   enqueue $adjacentVertex")
                }
            }
        }

        return result
    }

    fun searchFromWiki(): MutableList<Int> {
        val used = BooleanArray(adjacencyVectors.size)
        val result = mutableListOf<Int>()

        // LIFO
        val stack: Stack<Int> = Stack<Int>()
        stack.add(0)

        while (stack.isNotEmpty()) {
            val currVertex = stack.pop()
            println("current vertex $currVertex")
            if (!used[currVertex]) {
//  помечаем не сразу при добавлении в стзк, а только при извлечении, потому что интересует самый длинный путь до
//  до вершины.
                used[currVertex] = true

                result.add(currVertex)
//                used[currVertex] = true
                for (i in 0 until adjacencyVectors[currVertex].size) {
                    val adjacentVertex = adjacencyVectors[currVertex][i]
                    if (
                        !used[adjacentVertex]
                    ) {
                        println("   enqueue $adjacentVertex")
                        stack.push(adjacentVertex)
                    }
                }
            }
        }

        return result
    }

}

fun main() {
//    Traversal order: 0 1 3 2 4
    val dsf = DepthFirstSearch()
    dsf.search().apply { println(toString()) }
    dsf.searchFromWiki().apply { println(toString()) }
}