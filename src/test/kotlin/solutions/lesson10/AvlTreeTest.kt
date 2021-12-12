package solutions.lesson10

import org.junit.jupiter.api.Assertions.*
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

    @Test
    fun givenEmptyTree_whenHeightCalled_shouldReturnMinus1() {
        val tree = AvlTree()
        assertEquals(-1, tree.height())
    }

    @Test
    fun givenEmptyTree_whenInsertCalled_heightShouldBeZero() {
        val tree = AvlTree()
        tree.insert(1)
        assertEquals(0, tree.height())
    }

    @Test
    fun givenEmptyTree_whenInsertCalled_treeShouldBeAvl() {
        val tree = AvlTree()
        tree.insert(1)
        assertTrue(isAVL(tree))
    }

    @Test
    fun givenSampleTree_whenInsertCalled_treeShouldBeAvl() {
        val tree: AvlTree = getSampleAvlTree()
        val newKey = 11
        tree.insert(newKey)
        assertTrue(isAVL(tree))
    }

    @Test
    fun givenSampleTree_whenFindExistingKeyCalled_shouldReturnMatchedNode() {
        val tree: AvlTree = getSampleAvlTree()
        val existingKey = 2
        val result = tree.find(existingKey)
        assertEquals(result!!.key, existingKey)
    }

    @Test
    fun givenSampleTree_whenFindNotExistingKeyCalled_shouldReturnNull() {
        val tree: AvlTree = getSampleAvlTree()
        val notExistingKey = 11
        val result = tree.find(notExistingKey)
        assertNull(result)
    }

    @Test
    fun givenEmptyTree_whenDeleteCalled_treeShouldBeAvl() {
        val tree = AvlTree()
        tree.delete(1)
        assertTrue(isAVL(tree))
    }

    @Test
    fun givenSampleTree_whenDeleteCalled_treeShouldBeAvl() {
        val tree: AvlTree = getSampleAvlTree()
        tree.delete(1)
        assertTrue(isAVL(tree, tree.getRoot()))
    }

    private fun isAVL(tree: AvlTree): Boolean {
        return isAVL(tree, tree.getRoot())
    }

    private fun isAVL(tree: AvlTree, node: AvlTree.Node?): Boolean {
        if (node == null) return true
        val balance: Int = tree.getBalance(node)
        return balance <= 1 && balance >= -1 && isAVL(tree, node.left) && isAVL(tree, node.right)
    }

    private fun getSampleAvlTree(): AvlTree {
        val avlTree = AvlTree()
        for (i in 0..9) avlTree.insert(i)
        return avlTree
    }
}