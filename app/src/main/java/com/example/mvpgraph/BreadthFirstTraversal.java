package com.example.mvpgraph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal implements IGraphTraversal{

    @Override
    public LinkedList<Vertex> traverse(Graph g,Vertex v,LinkedList<Vertex> path) {
        Queue<Vertex> q = new LinkedList<>();
        q.add(v);
        v.setVisited(true);
        while(!q.isEmpty()){
            Vertex next = q.remove();
            path.add(next);
            LinkedList<Edge> edgeList = g.getEdgeList(next);
            for(Edge e : edgeList){
                if(!e.getDst().getVisited()){
                    q.add(e.getDst());
                    e.getDst().setVisited(true);
    }
    }
}
        return path;
    }
}
