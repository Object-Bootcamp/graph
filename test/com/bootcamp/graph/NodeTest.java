package com.bootcamp.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    @Test()
    public void nodeShouldHaveName() {
        GraphNode node = new GraphNode("A");
        String actualName = node.getName();
        assertEquals("A", actualName);
    }

    @Test
    public void nodeShouldReachableToItself() {
        GraphNode node = new GraphNode("A");
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldNotBeReachableWhenNodesAreDisconnected() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        assertFalse(nodeA.canReach(nodeB));
    }

    @Test
    public void nodeShouldBeReachableWhenTheyAreConnected() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode reachableNode = new GraphNode("node to be reached");
        nodeA.addNeighbour(reachableNode);
        assertTrue(nodeA.canReach(reachableNode));
        assertFalse(reachableNode.canReach(nodeA));
    }

    @Test
    public void nodeShouldReachableToMultipleNeighbours() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode neighbourOne = new GraphNode("Neighbour one");
        GraphNode neighbourTwo = new GraphNode("Neighbour two");
        nodeA.addNeighbour(neighbourOne);
        nodeA.addNeighbour(neighbourTwo);
        assertTrue(nodeA.canReach(neighbourOne));
        assertTrue(nodeA.canReach(neighbourTwo));
    }

    @Test
    public void shouldReachToDistinctNodeViaConnectedNode() {
        GraphNode startNode = new GraphNode("A");
        GraphNode intermediateNode = new GraphNode("B");
        GraphNode finalNode = new GraphNode("C");
        startNode.addNeighbour(intermediateNode);
        intermediateNode.addNeighbour(finalNode);

        assertTrue(startNode.canReach(finalNode));
    }

    @Test
    public void shouldBeReachableWhenHaveMultipleNeighbours() throws Exception {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        nodeA.addNeighbour(nodeB);
        nodeB.addNeighbour(nodeC);
        nodeA.addNeighbour(nodeD);
        nodeD.addNeighbour(nodeE);

        assertTrue(nodeA.canReach(nodeC));
        assertTrue(nodeA.canReach(nodeE));

    }
}
