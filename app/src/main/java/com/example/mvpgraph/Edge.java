package com.example.mvpgraph;

import java.util.LinkedList;

public class Edge {
    private final Vertex src;
    private final Vertex dst;
    private float weight;
    final float DEFAULT_WEIGHT = 1.0f;

    public Vertex getSrc(){
        return src;
    }

    public Vertex getDst(){
        return dst;
    }

    public float getWeight(){return weight; }

    // Ask your self if this makes sense...
    // can we create an edge with no src and dst?
    // this could be private...
    public Edge() {
        src = null;
        dst = null;
        weight = 0.0f;
    }

    public Edge(Vertex s, Vertex d, float w) {
        src = s;
        dst = d;
        weight = w;
    }

}
