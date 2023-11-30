package chapter2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RemoveDupesTest {

    private val removeDupes = RemoveDupes()

    @Test
    fun `when the node has no child, return node`() {
        assertEquals(1, removeDupes.removeDuplicateNodes(Node(1)).value)
    }

    @Test
    fun `when list contains no dupes, return list`() {
        val linkedList = buildLinkedList(listOf(1, 2, 3))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        assertEquals(1, head.value)
        assertEquals(2, head.next?.value)
        assertEquals(3, head.next?.next?.value)
        assertNull(head.next?.next?.next)
    }

    @Test
    fun `when list contains duplicates, return list with only unique elements`() {
        val linkedList = buildLinkedList(listOf(1, 2, 2, 2, 3))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        assertEquals(1, head.value)
        assertEquals(2, head.next?.value)
        assertEquals(3, head.next?.next?.value)
        assertNull(head.next?.next?.next)
    }

    @Test
    fun `when list contains many duplicates, return list with only unique elements`() {
        val linkedList = buildLinkedList(listOf(1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        assertEquals(1, head.value)
        assertEquals(2, head.next?.value)
        assertEquals(3, head.next?.next?.value)
        assertEquals(4, head.next?.next?.next?.value)
        assertNull(head.next?.next?.next?.next)
    }

    private fun buildLinkedList(values: List<Int>): Node {
        val head = Node(values.first())
        val rest = values.drop(1)

        rest.fold(head) { prevNode, curr ->
            val newNode = Node(curr)
            prevNode.next = newNode
            newNode
        }

        return head
    }
}
