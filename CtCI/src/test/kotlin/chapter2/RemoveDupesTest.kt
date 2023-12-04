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
        val linkedList = buildLinkedList(listOf(0, 1, 2))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        head.iterator().withIndex().forEach {
            assertEquals(it.index, it.value)
        }
        assertEquals(3, head.count())
    }

    @Test
    fun `when list contains duplicates, return list with only unique elements`() {
        val linkedList = buildLinkedList(listOf(0, 1, 2, 2, 2, 3))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        head.iterator().withIndex().forEach {
            assertEquals(it.index, it.value)
        }
        assertEquals(4, head.count())
    }

    @Test
    fun `when list contains many duplicates, return list with only unique elements`() {
        val linkedList = buildLinkedList(listOf(0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4))

        val head = removeDupes.removeDuplicateNodes(linkedList)

        head.iterator().withIndex().forEach {
            assertEquals(it.index, it.value)
        }
        assertEquals(5, head.count())
    }

    private fun buildLinkedList(values: List<Int>): Node<Int> {
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
