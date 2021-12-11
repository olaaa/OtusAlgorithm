package solutions.lesson10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.log2

class AvlTreeTest {
    @Test
    fun comparePerformance() {
        val tree1 = AvlTree()
        val random = Random()

        val treeSize = 1_000_000 / 7 // 142857
        val randoms = mutableListOf<Int>()
        for (i in 0 until treeSize) {
            randoms.add(i)
        }
        randoms.shuffle()

        assertTrue(randoms.size == treeSize)

        randoms.forEach { tree1.insert(it) }
        assertEquals(treeSize, tree1.size())

        val tree2 = AvlTree()
        for (i in 0 until treeSize) {
            tree2.insert(i)
        }
        assertEquals(treeSize, tree2.size())

        val ints: IntArray = random.ints((treeSize / 10).toLong(), 0, treeSize).toArray()
//    Искать N/10 случайных чисел в каждом дереве.
        val start1 = System.currentTimeMillis()
        ints.forEach { tree1.find(it) }
        println(System.currentTimeMillis() - start1)

        val start2 = System.currentTimeMillis()
        ints.forEach { tree2.find(it) }
        println(System.currentTimeMillis() - start2)

        //    Удалить N/10 случайных элементов в каждом дереве.
        val start10 = System.currentTimeMillis()
        ints.forEach { tree1.delete(it) }
        println(System.currentTimeMillis() - start10)

        val start20 = System.currentTimeMillis()
        ints.forEach { tree2.delete(it) }
        println(System.currentTimeMillis() - start20)

        treeSize.div(log2(treeSize.toDouble())).also { println(it) }
    }

}