package chapter2

/*
Write code to remove duplicates from an unsorted linked list
 */
class RemoveDupes {

    fun removeDuplicateNodes(node: Node): Node {
        if (node.next == null) {
            return node
        }

        var curr = node
        var next = node.next

        val seen = mutableSetOf<Int>()
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

// TODO iterator for more fluent testing
class Node(val value: Int) {
    var next: Node? = null
}
