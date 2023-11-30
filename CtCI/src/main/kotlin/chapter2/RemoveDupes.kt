package chapter2

import com.sun.org.apache.xerces.internal.dom.ChildNode

/*
Write code to remove duplicates from an unsorted linked list
 */
class RemoveDupes {

    fun removeDuplicateNodes(node: Node): Node {
        if (node.next == null) {
            return node
        }
        val seen = mutableSetOf<String>()

        var curr: Node = node
        var next: Node? = node.next

        seen.add(curr.value)

        while (next != null) {
            if (seen.contains(next.value)) {
                next = next.next!!
            } else {
                seen.add(next.value)
                curr.next = next
                curr = next
                next = next.next!!
            }
        }

        return node
    }
}

class Node(val value: String) {
    var next: Node? = null
}
