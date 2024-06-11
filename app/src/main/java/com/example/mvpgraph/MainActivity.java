package com.example.mvpgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MVP_Graph_Contract.View {

    MVP_Graph_Contract.Presenter presenter;
    int numberOfVertices = 0;
    TextView textViewNumberOfVertices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new GraphPresenter(this,new Graph());
        EditText editTextV0 = findViewById(R.id.editTextV0);
        Button buttonCreateVertex = findViewById(R.id.buttonCreateVertex);
        textViewNumberOfVertices = findViewById(R.id.textViewNumberOfVertices);

        buttonCreateVertex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editTextV0.getText().toString();
                Vertex vertex = new Vertex(enteredText);
                presenter.getGraph().addVertex(vertex);
                numberOfVertices++;
                updateNumberOfVerticesTextView();
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void updateNumberOfVerticesTextView() {
        textViewNumberOfVertices.setText("Number of Vertices: " + numberOfVertices);
    }
}