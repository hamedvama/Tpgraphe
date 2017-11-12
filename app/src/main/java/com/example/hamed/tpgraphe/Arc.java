package com.example.hamed.tpgraphe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by hamed on 11/10/2017.
 */

public class Arc {

    private Node noeudorigin;
    private Node noeudefin;
    private int Xorig, Yorig, Xfin, Yfin;
    private int midX, midY;
    private Paint paint;
    private String color = "RED";

    public Arc(Node nodorig, Node nodext) {

        this.noeudorigin = nodorig;
        this.noeudefin = nodext;

        this.Xorig = nodorig.getX();
        this.Xfin = nodext.getX();
        this.Yorig = nodorig.getY();
        this.Yfin = nodext.getY();

        midX = (nodorig.getX()+nodext.getX())/2;
        midY = (nodorig.getY()+nodext.getY())/2;
        paint = new Paint();
        this.paint.setColor(Color.parseColor(color));

    }

    public int getXorig() {
        return Xorig;
    }

    public void setXorig(int xorig) {
        Xorig = xorig;
    }

    public int getYorig() {
        return Yorig;
    }

    public void setYorig(int yorig) {
        Yorig = yorig;
    }

    public int getXfin() {
        return Xfin;
    }

    public void setXfin(int xfin) {
        Xfin = xfin;
    }

    public int getYfin() {
        return Yfin;
    }

    public void setYfin(int yfin) {
        Yfin = yfin;
    }

    public int getMidX() {
        return midX;
    }

    public void setMidX(int midX) {
        this.midX = midX;
    }

    public int getMidY() {
        return midY;
    }

    public void setMidY(int midY) {
        this.midY = midY;
    }

    public Node getNoeudorigin() {
        return noeudorigin;
    }

    public Node getNoeudefin() {
        return noeudefin;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNoeudorigin(Node noeudorigin) {
        this.noeudorigin = noeudorigin;
    }

    public void setNoeudefin(Node noeudefin) {
        this.noeudefin = noeudefin;
    }
}
