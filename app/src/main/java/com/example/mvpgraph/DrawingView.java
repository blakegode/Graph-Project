package com.example.graphapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Spinner;

import java.util.LinkedList;

public class DrawingView extends View {
    private Paint paint = new Paint();
    private MVP_Graph_Contract.Presenter presenter;
    private Spinner spinner;
    private Vertex vertex1 = null;
    private Vertex vertex2 = null;
    private DepthFirstTraversal DFT;
    private boolean isTraversing = false;
    private LinkedList<Edge> DFTPath;
    private int counter;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        DFT = new DepthFirstTraversal();
    }

    public void setPresenter(MVP_Graph_Contract.Presenter presenter, Spinner spinner) {
        this.presenter = presenter;
        this.spinner = spinner;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Vertex vertex : presenter.getGraph().getVertices()) {
            canvas.drawCircle(vertex.getX(), vertex.getY(), 10, paint);
            for (Edge edge : presenter.getGraph().getEdgeList(vertex)) {
                canvas.drawLine(edge.getSrc().getX(),edge.getSrc().getY(),edge.getDst().getX(),edge.getDst().getY(),paint);
                Log.d("Debug", "Edges gets displayed");
            }
        }

        if (isTraversing) {
            paint.setColor(Color.RED);
            paint.setStrokeWidth(8);

            for (Vertex visitedVertex : DFT.getVisitedVertices()) {
                canvas.drawCircle(visitedVertex.getX(), visitedVertex.getY(), 15, paint);
            }

            for (Edge visitedEdge : DFT.getVisitedEdges()) {
                canvas.drawLine(
                        visitedEdge.getSrc().getX(),
                        visitedEdge.getSrc().getY(),
                        visitedEdge.getDst().getX(),
                        visitedEdge.getDst().getY(),
                        paint
                );
            }

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();
        float screenHeight = getHeight();
        float touchY = event.getY();
        float touchX = event.getX();

        if (touchY >= 0.2 * screenHeight) {
            switch (spinner.getSelectedItemPosition()) {
                case 0:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        presenter.handleVertex(touchX, touchY);
                        invalidate();
                    }
                    break;
                case 1:
                    Log.d("Debug", "Touch in option two");
                    if (isAVertexAtTouch(touchX, touchY, 20)) {
                        if (vertex1 == null) {
                            vertex1 = findVertexAt(touchX,touchY,20);
                            Log.d("Debug", "Vertex1 added");
                        } else {
                            vertex2 = findVertexAt(touchX,touchY,20);
                            Log.d("Debug", "Vertex2 added");
                            invalidate();
                            if (vertex1 != vertex2 && !presenter.getGraph().containsEdge(vertex1, vertex2)) {
                                if(presenter.getGraph().addEdge(vertex1,vertex2,3)){
                                    Log.d("Debug", "Edge Added to Graph");
                                }

                            }
                            vertex1 = null;
                            vertex2 = null;
                            invalidate();
                        }
                    }
                    break;
                case 2:
                    if (isAVertexAtTouch(touchX, touchY, 20)) {
                        Vertex selectedVertex = findVertexAt(touchX, touchY, 20);
                        if (selectedVertex != null) {
                            DFT = new DepthFirstTraversal();
                            LinkedList<Vertex> path = DFT.traverse(presenter.getGraph(),selectedVertex,new LinkedList<Vertex>());
                            for(int i=0;i>path.size();i++){

                            }
                        }
                    }
                    break;

                case 3:
                    Log.d("Debug", "Selected fourth item");
                    // Handle other cases as needed
                    break;
                case 4:
                    Log.d("Debug", "Selected other items");
                    // Handle other cases as needed
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick(){
        super.performClick();
        return true;
    }

    public MVP_Graph_Contract.Presenter getPresenter() {
        return presenter;
    }

    public void makeCircle(Canvas canvas, float x, float y){
        canvas.drawCircle(x,y,10,paint);
    }

    private Vertex findVertexAt(float x, float y, float radius) {
        for (Vertex vertex : presenter.getGraph().getVertices()) {
            float distance = GraphPresenter.calculateDistance(new Vertex("", x, y,15), vertex);
            if (distance <= radius) {
                return vertex;
            }
        }
        return null;
    }
    private boolean isAVertexAtTouch(float x, float y, float radius){
        for (Vertex vertex : presenter.getGraph().getVertices()) {
            float distance = GraphPresenter.calculateDistance(new Vertex("", x, y,15), vertex);
            if (distance <= radius) {
                return true;
            }
        }
        return false;
    }


}