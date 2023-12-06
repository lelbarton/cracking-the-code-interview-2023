package ch4treesAndGraphs

import kotlin.math.abs
import kotlin.math.max

/*
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
class CheckBalanced {

    fun <T> isBalanced(root: TreeNode<T>?) : Boolean {
        if (root == null) {
            return true
        }

        val leftHeight = getHeight(root.leftChild)
        val rightHeight = getHeight(root.rightChild)

        val diff = abs(leftHeight - rightHeight)
        return diff <= 1
    }

    private fun <T> getHeight(node: TreeNode<T>?): Int {
        if (node == null) { return 0 }
        return max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1
    }
}
