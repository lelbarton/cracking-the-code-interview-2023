package chapter2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RemoveDupesTest {

    private val removeDupes = RemoveDupes()

    @Test
    fun `when the node has no child, return node`() {
        val node = Node("one")
        assertEquals(node, removeDupes.removeDuplicateNodes(node))
    }
}
