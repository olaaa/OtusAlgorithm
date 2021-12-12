package solutions.lesson10

class AvlTree {
    class Node internal constructor(var key: Int) {
        var height = 1
        var left: Node? = null
        var right: Node? = null
    }

    private var root: Node? = null

    fun find(key: Int): Node? {
        var current = root
        while (current != null) {
            if (current.key == key) {
                break
            }
            current = if (current.key < key) current.right else current.left
        }
        return current
    }

    fun insert(key: Int) {
        root = insert(root, key)
    }

    fun delete(key: Int) {
        root = delete(root, key)
    }

    fun getRoot(): Node? {
        return root
    }

    fun height(): Int {
        return if (root == null) 0 else root!!.height
    }

    private fun insert(node: Node?, key: Int): Node {
        if (node == null) {
            return Node(key)
        } else if (node.key > key) {
            node.left = insert(node.left, key)
        } else if (node.key < key) {
            node.right = insert(node.right, key)
        } else {
            throw RuntimeException("duplicate Key!")
        }
        return rebalance(node)
    }

    private fun delete(node: Node?, key: Int): Node? {
        var node = node
        if (node == null) {
            return node
        } else if (node.key > key) {
            node.left = delete(node.left, key)
        } else if (node.key < key) {
            node.right = delete(node.right, key)
        } else {
            if (node.left == null || node.right == null) {
                node = if (node.left == null) {
                    node.right
                } else {
                    node.left
                }
            } else {
                val mostLeftChild = mostLeftChild(node.right)
                node.key = mostLeftChild.key
                node.right = delete(node.right, node.key)
            }
        }
        if (node != null) {
            node = rebalance(node)
        }
        return node
    }

    private fun mostLeftChild(node: Node?): Node {
        var current = node
        /* loop down to find the leftmost leaf */
        while (current!!.left != null) {
            current = current.left
        }
        return current
    }

    private fun rebalance(z: Node): Node {
        var node: Node = z
        updateHeight(node)
        val balance = getBalance(node)
        if (balance > 1) {
            if (height(node.right!!.right) > height(node.right!!.left)) {
                node = rotateLeft(node)
            } else {
                node.right = rotateRight(node.right)
                node = rotateLeft(node)
            }
        } else if (balance < -1) {
            if (height(node.left!!.left) > height(node.left!!.right)) {
                node = rotateRight(node)
            } else {
//                большой поворот направо
                node.left = rotateLeft(node.left)
                node = rotateRight(node)
            }
        }
        return node
    }

    private fun rotateRight(node: Node?): Node {
        val left = node!!.left
        val leftRight = left!!.right
        left.right = node
        node.left = leftRight
        updateHeight(node)
        updateHeight(left)
        return left
    }

    private fun rotateLeft(node: Node?): Node {
        val right = node!!.right
        val rightLeft = right!!.left
        right.left = node
        node.right = rightLeft
        updateHeight(node)
        updateHeight(right)
        return right
    }

    private fun updateHeight(n: Node?) {
        n!!.height = 1 + Math.max(height(n.left), height(n.right))
    }

    private fun height(n: Node?): Int {
        return n?.height ?: 0
    }

    fun getBalance(n: Node?): Int {
        return if (n == null) {
            0
        } else {
//            положит или отриц число
            height(n.right) - height(n.left)
        }
    }

    fun size(): Int =
        size(root)

    private fun size(node: Node?): Int {
        if (node == null) {
            return 0
        }

        return size(node.left) + 1 + size(node.right)
    }
}