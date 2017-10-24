package com.example.hamed.tpgraphe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    DrawableGraph Dgraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dgraph = new DrawableGraph();
        setContentView(R.layout.activity_main);
        ImageView img = new ImageView(this);
        img.setImageDrawable(Dgraph);

    }
}
