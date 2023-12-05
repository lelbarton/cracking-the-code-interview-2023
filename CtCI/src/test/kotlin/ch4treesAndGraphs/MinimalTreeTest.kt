package ch4treesAndGraphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimalTreeTest {

    @Test
    fun `when elements is empty, return empty tree`() {
        assertNull(MinimalTree(listOf()).root)
    }

    @Test
    fun `when there is one element, it is the only node`() {
        val tree = MinimalTree(listOf(5))

        assertEquals(5, tree.root?.element)
        assertNull(tree.root?.leftChild)
        assertNull(tree.root?.rightChild)
    }

    @Test
    fun `when there are multiple elements, the tree is correctly constructed`() {
        val tree = MinimalTree(listOf(1,2,3,4,5))

        assertEquals(3, tree.root?.element)
        assertEquals(1, tree.root?.leftChild?.element)
        assertEquals(2, tree.root?.leftChild?.rightChild?.element)
        assertEquals(4, tree.root?.rightChild?.element)
        assertEquals(5, tree.root?.rightChild?.rightChild?.element)
        assertNull(tree.root?.rightChild?.leftChild)
    }
}
