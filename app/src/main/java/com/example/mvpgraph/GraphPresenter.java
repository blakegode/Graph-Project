package com.example.mvpgraph;

import android.util.Log;

public class GraphPresenter implements MVP_Graph_Contract.Presenter{
    MVP_Graph_Contract.View view;
    Graph graph;

    public GraphPresenter( MVP_Graph_Contract.View view, Graph graph) {
        this.view = view;
         this.graph = graph;
    }

    public Graph getGraph()
    {
        return graph;
    }

    public void setGraph(Graph graph){
        this.graph = graph;
    }
}
