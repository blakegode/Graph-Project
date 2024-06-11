package com.example.mvpgraph;

import java.util.Objects;

public class Vertex {
    public Vertex() {
        vLabel = "Unassigned";
    }

    public Vertex(String label) {
        vLabel = label;
    }

    private String vLabel;
    private boolean visited = false;
    public String getLabel() {
        return vLabel;
    }

    public void setVisited(boolean status){

        visited = status;
    }
    public boolean getVisited(){

        return visited;
    }
    @Override
    public String toString() {
        return vLabel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return vLabel.equals(vertex.vLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vLabel);
    }

}

