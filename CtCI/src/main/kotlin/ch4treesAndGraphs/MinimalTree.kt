package ch4treesAndGraphs

/*
4.2 Given a sorted (increasing order) array with unique integer elements, write an algorithm to
create a binary search tree with minimal height.
 */
class MinimalTree(private val elements: List<Int>) {

    var root: TreeNode<Int>?

    init {
        this.root = constructTree(0, elements.size - 1)
    }

    // We need to traverse all elements, so this runs in O(n) where n is number of elements
    private fun constructTree(leftBound: Int, rightBound: Int): TreeNode<Int>? {
        if (leftBound == rightBound) {
            return TreeNode(elements[leftBound])
        }

        if (leftBound > rightBound) {
            return null
        }

        val midpoint: Int = (rightBound + leftBound) / 2

        return TreeNode(
            elements[midpoint],
            constructTree(leftBound, midpoint - 1),
            constructTree(midpoint + 1, rightBound)
        )
    }
}


