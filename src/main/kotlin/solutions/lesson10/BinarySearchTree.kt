package solutions.lesson10


open class BinarySearchTree {
    var root: Node? = null

    class Node(
        var key: Int // Comparable ?
    ) {
        var left: Node? = null
        var right: Node? = null

        override fun toString(): String {
            return "Node(key=$key)"
        }
    }

    fun insert(x: Int) {
        if (root == null) {
            root = Node(x)
            return
        }

        insertRecursively(x, root)
    }

    private fun insertRecursively(x: Int, node: Node?): Node {
        if (node == null) {
            return Node(x)
        }

        if (x > node.key) {
            node.right = insertRecursively(x, node.right)
        } else if (x < node.key) {
            node.left = insertRecursively(x, node.left)
        }

        return node
    }

    fun inorderTraversal(node: Node? = root) {
        if (node == null) {
            return
        }

        inorderTraversal(node.left)
        println(node.key)
        inorderTraversal(node.right)
    }

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

    fun minimum(): Int? {
        return root?.let { minimum(it).key }
    }

    private fun minimum(node: Node): Node {
        if (node.left == null) {
            return node
        }

        return minimum(node.left!!)
    }

    fun delete(x: Int) {
        removeRecursively(root, x)
    }

    private fun removeRecursively(node: Node?, keyToRemove: Int): Node? {
        if (node == null) {
            return null
        }

        if (keyToRemove > node.key) {
            node.right = removeRecursively(node.right, keyToRemove)
        } else if (keyToRemove < node.key) {
            node.left = removeRecursively(node.left, keyToRemove)
        }
//        node.key = keyToRemove
        else if (node.left != null && node.right != null) {
            node.key = minimum(node.right!!).key
//            удалить найденный минимальный элемент
            node.right = removeRecursively(node.right, node.key)
        } else { // какой-то из потомков равен null
            return if (node.left != null) {
                node.left
            } else if (node.right != null) {
                node.right
            } else {
                null
            }
        }
        return node
    }

    fun size(): Int {
        return sizeRecursively(root)
    }

    private fun sizeRecursively(node: Node?): Int {
        if (node == null) {
            return 0
        }

        return sizeRecursively(node.right) + 1 + sizeRecursively(node.left)
    }
}