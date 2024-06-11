package com.example.mvpgraph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    public Graph() {
        m_adjacencyList = new HashMap<Vertex, LinkedList<Edge>>( 1024 );
    }

    public int getNumVertices() {
        return m_adjacencyList.size();
    }

    public void addVertex( Vertex v ) {
        if (!m_adjacencyList.containsKey(v)) {
            m_adjacencyList.put(v, new LinkedList<Edge>());
        }
    }

    public Vertex getVertexByLabel(String label){
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {
            Vertex vertex = hEntry.getKey();
            if(vertex.getLabel().equals(label)){
                return vertex;
            }

        }
        return null;
    }

    public void addEdge( Vertex src, Vertex dst, float w ) {
        if ((m_adjacencyList.containsKey( src )) && (m_adjacencyList.containsKey( dst ))) {
            m_adjacencyList.get(src).add(new Edge(src,dst,w));
        }
    }

    public Edge getEdge(Vertex src, Vertex dst){
        LinkedList<Edge> edgeList = m_adjacencyList.get(src);
            for (Edge edge : edgeList) {
                if (edge.getSrc() == src && edge.getDst() == dst) {
                    return edge;
                }
            }
        return null;
    }

    public void printAdjacencyList() {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> entry : m_adjacencyList.entrySet()) {
            Vertex vertex = entry.getKey();
            LinkedList<Edge> edgeList = entry.getValue();

            System.out.print(vertex.getLabel() + ": ");
            for (Edge edge : edgeList) {
                System.out.print(" -> " + edge.getDst().getLabel());
            }
            System.out.println(" -> nil");
        }
    }

    public LinkedList<Vertex> getNeighbors(Vertex v){
        LinkedList<Edge> edgeList = m_adjacencyList.get(v);
        LinkedList<Vertex> neighborList = new LinkedList<Vertex>();
        for(Edge edge : edgeList){
            neighborList.add(edge.getDst());
        }
        return neighborList;
    }

    public LinkedList<Edge> getEdgeList(Vertex v){
        return m_adjacencyList.get(v);
    }
    private HashMap< Vertex, LinkedList< Edge >> m_adjacencyList;
}
