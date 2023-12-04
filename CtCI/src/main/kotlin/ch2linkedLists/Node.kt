package ch2linkedLists

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
