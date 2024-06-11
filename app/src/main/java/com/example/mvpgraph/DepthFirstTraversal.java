package com.example.mvpgraph;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstTraversal implements IGraphTraversal{

    @Override
    public LinkedList<Vertex> traverse(Graph g,Vertex v,LinkedList<Vertex> path) {
        Stack<Vertex> stack = new Stack<>();

        stack.push(v);
        v.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();


            LinkedList<Edge> edgeList = g.getEdgeList(current);
            for (Edge e : edgeList) {
                Vertex neighbor = e.getDst();
                if (!neighbor.getVisited()) {
                    stack.push(neighbor);
                    neighbor.setVisited(true);
                }
            }
            path.add(current);
        }

        return path;
    }
}
