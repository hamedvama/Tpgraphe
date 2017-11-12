package com.example.hamed.tpgraphe;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by hamed on 04/10/2017.
 */

public class Node {

    private String etiq;
    private int abs, ord, ray;
    private String color="";
    private Paint paint = new Paint();
    private int taille;


    public Node(int x, int y){
        this.etiq = "Noeud";
        if(x<50){this.abs = x+(50-x);} else {this.abs = x;}
        if(y<50){this.ord = y+(50-y);} else {this.ord = y;}
        this.ray = 50;
        this.paint.setColor(Color.parseColor("GRAY"));
    }
    public Node (String etique, int x, int y, int z, String color){

        this.etiq = etique;
        if(x<z){this.abs = x + (z - x);} else {this.abs = x;}
        if(y<z){this.ord = y + (z - y);} else {this.ord = y;}
        this.ray = z;
        this.color = color;
        this.paint.setColor(Color.parseColor(color));
    }

    public Node() {

    }

    public boolean egalnode(Node node){
        Boolean egale = false;
                if(this.getX() == node.getX() && this.getX() == node.getX()){
                    egale = true;
                }
        return  egale;
    }

    public void misajour(int x, int y){
        if(x<50){ this.abs = x+(50-x);} else {this.abs = x;}
        if(y<50){ this.ord = y+(50-y);} else {this.ord = y;}
    }

    public boolean supnode (Node nouveau){

        float alpha = (this.abs - nouveau.abs)*(this.abs - nouveau.abs);
        float beta = (this.ord - nouveau.ord)*(this.ord - nouveau.ord);
        Log.e("test"," alpha ="+ alpha+" beta =" + beta);
        double distance = Math.sqrt(alpha + beta);
        Log.e("test","la racine ="+distance);
        float somray = this.ray + nouveau.ray;
        Log.e("test","somme rayon ="+ somray);
        boolean result = distance < somray;
        Log.e("test","resultat de test superpose =" + result );
        return result ;

    }

    public static boolean supnode (Node n1, Node n2){
        return n1.supnode(n2);
    }

    public String getEtiq() {
        return etiq;
    }

    public int getX() {
        return abs;
    }

    public int getY() {
        return ord;
    }

    public int getRay() {
        return ray;
    }

    public Paint getPaint() { return paint; }

    public String getColor() {
        return color;
    }

    public void setEtiq(String etiq) { this.etiq = String.valueOf(etiq); }

    public void setX(int x) { this.abs = x; }

    public void setY(int y) { this.ord = y; }

    public void setRay(int z) { this.ray = z; }

    public void setColor(String color) { this.color = color; }

    public void setPaint(Paint paint) { this.paint = paint; }
}
