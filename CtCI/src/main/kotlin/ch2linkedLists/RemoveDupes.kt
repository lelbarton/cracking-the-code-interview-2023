package ch2linkedLists

/*
2.1 Write code to remove duplicates from an unsorted linked list
 */
class RemoveDupes {

    // We traverse the list once, skipping any values previously seen. This therefore runs in O(n)
    fun <T> removeDuplicateNodes(linkedListNode: LinkedListNode<T>): LinkedListNode<T> {
        if (linkedListNode.next == null) {
            return linkedListNode
        }

        var curr = linkedListNode
        var next = linkedListNode.next

        val seen = mutableSetOf<T>()
        seen.add(curr.value)

        while(next != null) {
            if (seen.contains(next.value)) {
                next = next.next
            } else {
                seen.add(next.value)
                curr.next = next
                curr = next
            }
        }
        curr.next = null

        return linkedListNode
    }
}
