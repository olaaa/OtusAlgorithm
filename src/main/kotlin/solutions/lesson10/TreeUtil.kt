package solutions.lesson10

import java.io.PrintStream

private fun BinarySearchTree.traverseNodes(
    sb: StringBuilder, padding: String?, pointer: String?, node: BinarySearchTree.Node?,
    hasRightSibling: Boolean
) {
    if (node != null) {
        sb.append("\n")
        sb.append(padding)
        sb.append(pointer)
        sb.append(node.key)
        val paddingBuilder = StringBuilder(padding)
        if (hasRightSibling) {
            paddingBuilder.append("│  ")
        } else {
            paddingBuilder.append("   ")
        }
        val paddingForBoth = paddingBuilder.toString()
        val pointerRight = "└──"
        val pointerLeft = if (node.right != null) "├──" else "└──"
        traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null)
        traverseNodes(sb, paddingForBoth, pointerRight, node.right, false)
    }
}

private fun BinarySearchTree.traversePreOrder(root: BinarySearchTree.Node?): String {
    if (root == null) {
        return ""
    }
    val sb = StringBuilder()
    sb.append(root.key)
    val pointerRight = "└──"
    val pointerLeft = if (root.right != null) "├──" else "└──"
    traverseNodes(sb, "", pointerLeft, root.left, root.right != null)
    traverseNodes(sb, "", pointerRight, root.right, false)
    return sb.toString()
}

fun BinarySearchTree.print(os: PrintStream) {
    os.print(traversePreOrder(root))
}