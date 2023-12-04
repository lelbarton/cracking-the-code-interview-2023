package ch4treesAndGraphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RouteBetweenNodesTest {
    private val routeBetweenNodes = RouteBetweenNodes()

    @Test
    fun `when source and sink are the same node, path exists returns true`() {
        val s = GraphNode()
        assertTrue(routeBetweenNodes.pathExists(s, s))
    }

    @Test
    fun `when source and sink not connected, path exists returns false`() {
        val s = GraphNode()
        val e = GraphNode()
        assertFalse(routeBetweenNodes.pathExists(s, e))
    }

    @Test
    fun `when source and sink are directly connected, path exists returns true`() {
        val e = GraphNode()
        val s = GraphNode(mutableListOf(e))
        assertTrue(routeBetweenNodes.pathExists(s, e))
    }

    @Test
    fun `when source and sink are distantly connected, path exists returns true`() {
        val e = GraphNode()
        val k = GraphNode(mutableListOf(e))
        val m = GraphNode(mutableListOf(k))
        val l = GraphNode()
        val s = GraphNode(mutableListOf(m, l))
        assertTrue(routeBetweenNodes.pathExists(s, e))
    }

    @Test
    fun `when graph contain a cycle, function returns`() {
        val e = GraphNode()
        val k = GraphNode(mutableListOf(e))
        val s = GraphNode(mutableListOf(k))
        k.children.add(s)

        assertTrue(routeBetweenNodes.pathExists(s, e))
    }
}
