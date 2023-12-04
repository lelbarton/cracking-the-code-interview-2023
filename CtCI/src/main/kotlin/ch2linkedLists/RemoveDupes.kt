package ch2linkedLists

/*
Write code to remove duplicates from an unsorted linked list
 */
class RemoveDupes {

    fun <T> removeDuplicateNodes(node: Node<T>): Node<T> {
        if (node.next == null) {
            return node
        }

        var curr = node
        var next = node.next

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

        return node
    }
}
