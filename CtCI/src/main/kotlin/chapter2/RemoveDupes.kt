package chapter2

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

class Node<T>(val value: T) : Iterable<T> {
    var next: Node<T>? = null
    override fun iterator(): Iterator<T> = NodeIterator(this)
}

class NodeIterator<T>(head: Node<T>) : Iterator<T> {
    private var curr : Node<T>? = head
    override fun hasNext(): Boolean = curr != null

    override fun next(): T {
        val thisValue = curr?.value
        curr = curr?.next
        return thisValue!!
    }

}
