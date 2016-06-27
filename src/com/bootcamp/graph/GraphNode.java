package com.bootcamp.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private final String name;
    private List<GraphNode> neighbours;

    public GraphNode(String nodeName) {
        this.name = nodeName;
        this.neighbours = new LinkedList<GraphNode>();
    }

    public String getName() {
        return name;
    }

    public boolean canReach(GraphNode node) {
        if (this == node || this.neighbours.contains(node))
            return true;
        for (GraphNode n : this.neighbours) {
            if (n.canReach(node)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }

    public void addNeighbour(GraphNode reachableNode) {
        this.neighbours.add(reachableNode);
    }
}
