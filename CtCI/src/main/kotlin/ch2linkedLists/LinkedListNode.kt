package ch2linkedLists

class LinkedListNode<T>(val value: T) : Iterable<T> {
    var next: LinkedListNode<T>? = null
    override fun iterator(): Iterator<T> = LinkedListNodeIterator(this)
}

class LinkedListNodeIterator<T>(head: LinkedListNode<T>) : Iterator<T> {
    private var curr : LinkedListNode<T>? = head
    override fun hasNext(): Boolean = curr != null

    override fun next(): T {
        val thisValue = curr?.value
        curr = curr?.next
        return thisValue!!
    }
}
