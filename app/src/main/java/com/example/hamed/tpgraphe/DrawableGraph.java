package com.example.hamed.tpgraphe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hamed on 04/10/2017.
 */

public class DrawableGraph extends Drawable {

    private Graph graph = new Graph();
    private List<Node> listN= new LinkedList<>();


    @Override
    public void draw(@NonNull Canvas canvas) {

        canvas.drawColor(Color.MAGENTA);
        this.listN = graph.getListdenoeud();

        for ( int i=0;i<listN.size()-1 ;i++) {

            canvas.drawCircle(this.listN.get(i).getX(),this.listN.get(i).getY(),this.listN.get(i).getRay(),this.listN.get(i).getPaint());

        }
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
