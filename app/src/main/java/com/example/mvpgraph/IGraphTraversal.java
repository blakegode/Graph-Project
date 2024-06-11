package com.example.mvpgraph;

import java.util.LinkedList;

public interface IGraphTraversal {
    public LinkedList<Vertex> traverse(Graph g,Vertex v,LinkedList<Vertex> path);
}
