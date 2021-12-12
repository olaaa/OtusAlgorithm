package solutions.lesson10

class AvlTree {
    class Node internal constructor(var key: Int) {
        var height = 1
        var left: Node? = null
        var right: Node? = null
    }

    private var root: Node? = null

    fun search(x: Int): Boolean =
        searchRecursively(x, root)

    private fun searchRecursively(x: Int, node: Node?): Boolean {
        if (node == null) {
            return false
        }

        return if (x == node.key) {
            true
        } else if (x < node.key) {
            searchRecursively(x, node.left)
        } else if (x > node.key) {
            searchRecursively(x, node.right)
        } else {
            throw IllegalStateException()
        }
    }

    fun insert(key: Int) {
        root = insert(root, key)
    }

    fun delete(key: Int) {
        root = deleteRecursively(root, key)
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
        }

        return rebalance(node)
    }

    private fun deleteRecursively(node: Node?, key: Int): Node? {
        var node = node
        if (node == null) {
            return node
        } else if (node.key > key) {
            node.left = deleteRecursively(node.left, key)
        } else if (node.key < key) {
            node.right = deleteRecursively(node.right, key)
        } else {
            if (node.left == null || node.right == null) {
                node =
                    if (node.left == null) {
                        node.right
                    } else {
                        node.left
                    }
            } else { // оба потомка непустые
                val mostLeftChild = mostLeftChild(node.right!!)
                node.key = mostLeftChild.key
                node.right = deleteRecursively(node.right, node.key)
            }
        }
        if (node != null) {
            node = rebalance(node)
        }
        return node
    }

    private fun mostLeftChild(node: Node): Node {
        if (node.left == null) {
            return node
        }

        return mostLeftChild(node.left!!)
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
        node.left = left!!.right
        left.right = node
        updateHeight(node)
        updateHeight(left)
        return left
    }

    private fun rotateLeft(node: Node?): Node {
        val right = node!!.right
        node.right = right!!.left
        right.left = node
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