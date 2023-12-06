package ch4treesAndGraphs

/*
Given a binary tree, design an algorithm which creates a list of all the nodes at each depth
(e.g., if you have a tree with depth D, you'll have D linked lists)
 */
class ListOfDepths<T>(root: TreeNode<T>?) {

    val lists: MutableList<MutableList<TreeNode<T>>> = mutableListOf()

    init {
        getListOfDepthsRecursive(root, 0)
    }

    // We visit every node, so complexity is O(n)
    private fun getListOfDepthsRecursive(
        node: TreeNode<T>?,
        level: Int,
    ) {
        if (node == null) {
            return
        }

        val thisList: MutableList<TreeNode<T>> = if (lists.size == level) {
            // in this case we haven't "visited" this level yet, so make a new list
            val newList = mutableListOf<TreeNode<T>>()
            lists.add(newList)
            newList
        } else {
            // otherwise, get the existing list
            lists[level]
        }

        thisList.add(node)

        val nextLevel = level + 1
        getListOfDepthsRecursive(node.leftChild, nextLevel)
        getListOfDepthsRecursive(node.rightChild, nextLevel)
    }
}
