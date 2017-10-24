package com.example.hamed.tpgraphe;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by hamed on 04/10/2017.
 */

public class Node {

    private String etiq;
    private int x,y,ray;
    private String color;
    private Graph graph;
    private Paint paint;

    public Node (String etique, int abs, int ord, int ray, String color){

        this.etiq = etique;
        this.x = abs;
        this.y = ord;
        this.ray = ray;
        this.paint = new Paint();
        this.paint.setColor(Color.parseColor(color));
    }

    public String getEtiq() {
        return etiq;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRay() {
        return ray;
    }

    public Paint getPaint() { return paint; }

    public String getColor() {
        return color;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setEtiq(String etiq) { this.etiq = etiq; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setRay(int ray) { this.ray = ray; }

    public void setColor(String color) { this.color = color; }

    public void setGraph(Graph graph) { this.graph = graph; }

    public void setPaint(Paint paint) { this.paint = paint; }
}
