package ch4treesAndGraphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListOfDepthsTest {

    @Test
    fun `when tree is null, list of depths is empty`() {
        assertEquals(listOf<TreeNode<Int>>(), ListOfDepths<Int>(null).lists)
    }

    @Test
    fun `when tree has one node, list of depths has a single list`() {
        val root = TreeNode(1)
        assertEquals(listOf(listOf(root)), ListOfDepths(root).lists)
    }

    @Test
    fun `when tree is unbalanced, list of depths is correctly returned`() {
        val tree = TreeNode(1, TreeNode(2, TreeNode(3)))

        val depths = ListOfDepths(tree).lists

        assertEquals(3, depths.size)
        assertEquals(1, depths[0][0].element)
        assertEquals(2, depths[1][0].element)
        assertEquals(3, depths[2][0].element)
    }

    @Test
    fun `when tree is balanced, list of depths is correctly returned`() {
        val tree = TreeNode(1, TreeNode(2), TreeNode(3))

        val depths = ListOfDepths(tree).lists

        assertEquals(2, depths.size)
        assertEquals(1, depths[0][0].element)
        assertEquals(2, depths[1][0].element)
        assertEquals(3, depths[1][1].element)
    }
}
