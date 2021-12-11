package solutions.lesson10

class AvlTree {
    class Node internal constructor(var key: Int) {
        var height = 0
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
        return if (root == null) -1 else root!!.height
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
        var z: Node = z
        updateHeight(z)
        val balance = getBalance(z)
        if (balance > 1) {
            if (height(z.right!!.right) > height(z.right!!.left)) {
                z = rotateLeft(z)
            } else {
                z.right = rotateRight(z.right)
                z = rotateLeft(z)
            }
        } else if (balance < -1) {
            if (height(z.left!!.left) > height(z.left!!.right)) {
                z = rotateRight(z)
            } else {
                z.left = rotateLeft(z.left)
                z = rotateRight(z)
            }
        }
        return z
    }

    private fun rotateRight(y: Node?): Node {
        val x = y!!.left
        val z = x!!.right
        x.right = y
        y.left = z
        updateHeight(y)
        updateHeight(x)
        return x
    }

    private fun rotateLeft(y: Node?): Node {
        val x = y!!.right
        val z = x!!.left
        x.left = y
        y.right = z
        updateHeight(y)
        updateHeight(x)
        return x
    }

    private fun updateHeight(n: Node?) {
        n!!.height = 1 + Math.max(height(n.left), height(n.right))
    }

    private fun height(n: Node?): Int {
        return n?.height ?: -1
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