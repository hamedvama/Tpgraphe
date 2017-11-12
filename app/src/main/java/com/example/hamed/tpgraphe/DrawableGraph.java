package com.example.hamed.tpgraphe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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
    private  Canvas canvas;
    private Paint paint = new Paint();

    @Override
    public void draw(@NonNull Canvas canvas) {
        this.canvas = canvas;

        drawarc();
        nodedraw();

    }

    public void nodedraw() {
        paint.setColor(Color.parseColor("BLACK"));
        for ( int i=0; i < graph.getListdenoeud().size() ;i++) {

            canvas.drawCircle(this.graph.getListdenoeud().get(i).getX(),this.graph.getListdenoeud().get(i).getY(),
                    this.graph.getListdenoeud().get(i).getRay(),this.graph.getListdenoeud().get(i).getPaint());
            canvas.drawText(this.graph.getListdenoeud().get(i).getEtiq(),this.graph.getListdenoeud().get(i).getX()-15,
                    this.graph.getListdenoeud().get(i).getY(),paint);
            //Log.e("xx","liste :" + graph.getListdenoeud().get(i).toString());

        }
    }

    public void drawarc(){

        for ( int i=0; i < graph.getListdarc().size() ;i++) {
            int mx = 20 + (graph.getListdarc().get(i).getNoeudorigin().getX()+ graph.getListdarc().get(i).getNoeudefin().getX()) / 2;
            int my = 20 + (graph.getListdarc().get(i).getNoeudorigin().getY() + graph.getListdarc().get(i).getNoeudefin().getY()) / 2;

            float[] midPoint = {0f, 0f};
            float[] tangent = {0f, 0f};

            Path edgePath = new Path();
            edgePath.moveTo(graph.getListdarc().get(i).getNoeudorigin().getX(), graph.getListdarc().get(i).getNoeudorigin().getY());

            PathMeasure pm = new PathMeasure(edgePath, false);
            pm.getPosTan(pm.getLength() * 0.50f, midPoint, tangent);

            edgePath.quadTo(mx, my, graph.getListdarc().get(i).getNoeudefin().getX(), graph.getListdarc().get(i).getNoeudefin().getY());
            canvas.drawPath(edgePath, graph.getListdarc().get(i).getPaint());
        }

    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
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
