package solutions.lesson10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.FileOutputStream
import java.io.PrintStream
import java.util.*
import kotlin.math.log2

internal class BinarySearchTreeTest {
    @Test
    fun size() {
        val tree = createBst()
        assertEquals(7, tree.size())

        tree.print(PrintStream(FileOutputStream("tree.txt"), true, "utf-8"))
        tree.print(PrintStream(System.out, true, "utf-8"))
    }

    @Test
    fun insert() {
        val tree = createBst()
        assertEquals(7, tree.size())

        tree.insert(20)
        assertEquals(7, tree.size())
    }

    @Test
    fun minimum() {
        val tree = createBst()

        tree.inorderTraversal()
        assert(tree.minimum() == 20)
    }

    private fun createBst(): BinarySearchTree {
        val tree = BinarySearchTree()

        /*
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */

        tree.insert(50)
        tree.insert(30)
        tree.insert(20)
        tree.insert(40)
        tree.insert(70)
        tree.insert(60)
        tree.insert(80)
        return tree
    }

    @Test
    fun delete() {
        val tree = createBst()

        tree.delete(30)
        assert(tree.search(30).not())
        assertEquals(6, tree.size())
    }

    @Test
    fun comparePerformance() {
        val tree1 = BinarySearchTree()
        val random = Random()

        val treeSize: Long = 1_000_000 / 7 // 142857
        val randoms = mutableListOf<Int>()
        for (i in 0 until treeSize.toInt()) {
            randoms.add(i)
        }
        randoms.shuffle()

        assertTrue(randoms.size >= treeSize)

        val start00 = System.currentTimeMillis()
        randoms.forEach { tree1.insert(it) }
        assertEquals(treeSize.toInt(), tree1.size())
        println(System.currentTimeMillis() - start00)

        val tree2 = BinarySearchTree()
        val start01 = System.currentTimeMillis()
        for (i in 0 until treeSize.toInt()) {
            tree2.insert(i)
        }
        println(System.currentTimeMillis() - start01)

        assertEquals(treeSize.toInt(), tree2.size())

        val ints: IntArray = random.ints(treeSize / 10, 0, treeSize.toInt()).toArray()
//    Искать N/10 случайных чисел в каждом дереве.
        val start1 = System.currentTimeMillis()
        ints.forEach { tree1.search(it) }
        println(System.currentTimeMillis() - start1)

        val start2 = System.currentTimeMillis()
        ints.forEach { tree2.search(it) }
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