package com.example.graphapp;

public interface MVP_Graph_Contract {

    interface View {
    }

    interface Presenter {
        Graph getGraph();
        void setGraph(Graph graph);
        void handleVertex(float touchX, float touchY);
        void handleEdge(Vertex vertex1, Vertex vertex2);
    }

    interface Model {
    }
}