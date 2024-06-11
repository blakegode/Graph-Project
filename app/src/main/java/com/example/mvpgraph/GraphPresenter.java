package com.example.graphapp;

import android.graphics.Canvas;

public class GraphPresenter implements MVP_Graph_Contract.Presenter {
    private DrawingView drawingView;
    private Graph graph;

    public GraphPresenter(DrawingView drawingView, Graph graph) {
        this.drawingView = drawingView;
        this.graph = graph;
    }

    @Override
    public Graph getGraph() {
        return graph;
    }
    @Override
    public void setGraph(Graph screenGraph) {
        this.graph = graph;
    }

    @Override
    public void handleVertex(float touchX, float touchY) {
        graph.addVertex(new Vertex("Vertex", touchX, touchY,15));
    }

    @Override
    public void handleEdge(Vertex vertex1, Vertex vertex2) {
        float distance = calculateDistance(vertex1, vertex2);
        graph.addEdge(vertex1, vertex2, distance);
        drawingView.invalidate();
    }

    public static float calculateDistance(Vertex vertex1, Vertex vertex2) {
        float x1 = vertex1.getX();
        float y1 = vertex1.getY();

        float x2 = vertex2.getX();
        float y2 = vertex2.getY();

        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
