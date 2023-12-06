package ch4treesAndGraphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckBalancedTest {

    private val checkBalanced = CheckBalanced()

    @Test
    fun `when tree root is null, return true`() {
        assertTrue(checkBalanced.isBalanced<Int>(null))
    }

    @Test
    fun `when root is the only node, return true`() {
        assertTrue(checkBalanced.isBalanced(TreeNode(1)))
    }

    @Test
    fun `when tree is complex and exactly balanced, return true`() {
        assertTrue(checkBalanced.isBalanced(TreeNode(1, TreeNode(2), TreeNode(3))))
    }

    @Test
    fun `when tree is complex and has heights off by one, return true`() {
        assertTrue(checkBalanced.isBalanced(TreeNode(1, TreeNode(2))))
    }

    @Test
    fun `when tree is unbalanced, return false`() {
        assertFalse(checkBalanced.isBalanced(TreeNode(1, TreeNode(2, TreeNode(3)))))
    }
}
