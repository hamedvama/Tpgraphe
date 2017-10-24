package com.example.hamed.tpgraphe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by hamed on 04/10/2017.
 */

public class Graph  {

    private LinkedList<Node> listdenoeud;

    Node noeud1 = new Node("noeud1", 120, 100, 50, "GRAY");
    Node noeud2 = new Node("noeud1", 340, 100, 50, "GRAY");
    Node noeud3 = new Node("noeud1", 560, 100, 50, "GRAY");
    Node noeud4 = new Node("noeud1", 120, 400, 50, "GRAY");
    Node noeud5 = new Node("noeud1", 340, 400, 50, "GRAY");
    Node noeud6 = new Node("noeud1", 560, 400, 50, "GRAY");
    Node noeud7 = new Node("noeud1", 120, 700, 50, "GRAY");
    Node noeud8 = new Node("noeud1", 340, 700, 50, "GRAY");
    Node noeud9 = new Node("noeud1", 560, 700, 50, "RED");


    public LinkedList<Node> getListdenoeud() {

        return listdenoeud;
    }
    public void setListdenoeud(Node node){
        this.listdenoeud.add(node);
    }

    public Graph (){
        listdenoeud = new LinkedList<>();
        this.listdenoeud.add(noeud1);
        this.listdenoeud.add(noeud2);
        this.listdenoeud.add(noeud3);
        this.listdenoeud.add(noeud4);
        this.listdenoeud.add(noeud5);
        this.listdenoeud.add(noeud6);
        this.listdenoeud.add(noeud7);
        this.listdenoeud.add(noeud8);
        this.listdenoeud.add(noeud9);
    }

}
