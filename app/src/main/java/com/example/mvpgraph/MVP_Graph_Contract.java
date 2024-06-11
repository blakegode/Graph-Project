package com.example.mvpgraph;

public interface MVP_Graph_Contract {

    interface View {


    }

    interface Presenter {
        Graph getGraph();
        void setGraph(Graph graph);
    }
}
