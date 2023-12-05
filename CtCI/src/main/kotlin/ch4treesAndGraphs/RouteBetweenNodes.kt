package ch4treesAndGraphs

import java.util.ArrayDeque

/*
4.1 Given a directed graph and two nodes (S and E), design an algorithm to find out whether there is a route from S to E
 */
class RouteBetweenNodes {
    // Breadth-first tends to be more efficient for finding paths between two nodes,
    // both in terms of finding the relationship but also the shortest path, so we will use that over depth-first.

    // BFS runs on O(V + E) where V is nodes and E is edges
    fun  pathExists(start: GraphNode, end: GraphNode) : Boolean {
        if (start == end) {
            return true
        }

        val visited = mutableSetOf<GraphNode>()
        val toVisit = ArrayDeque<GraphNode>()
        toVisit.add(start)

        while (toVisit.isNotEmpty()) {
            val curr = toVisit.removeFirst()
            if (!visited.contains(curr)) {
                if (curr == end) return true
                visited.add(curr)
                toVisit.addAll(curr.children)
            }
        }
        return false
    }
}

// Making children a mutable list means we can create cycles in the graph
class GraphNode(val children: MutableList<GraphNode> = mutableListOf())

