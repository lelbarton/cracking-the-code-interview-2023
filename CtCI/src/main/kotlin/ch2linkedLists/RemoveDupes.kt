package ch2linkedLists

/*
Write code to remove duplicates from an unsorted linked list
 */
class RemoveDupes {

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
