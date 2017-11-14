package com.example.hamed.tpgraphe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hamed on 04/10/2017.
 */

public class Graph  {

    private LinkedList<Node> listdenoeud;
    private LinkedList<Arc> listdarc;
    private LinkedList<Arc> listdarctemp;

    Node noeud1 = new Node("noeud1", 120, 30, 50, "RED");     Node noeud2 = new Node("noeud2", 340, 100, 50, "GRAY");
    Node noeud3 = new Node("noeud3", 560, 100, 50, "GRAY");     Node noeud4 = new Node("noeud4", 120, 400, 50, "GRAY");
    Node noeud5 = new Node("noeud5", 340, 400, 50, "GRAY");     Node noeud6 = new Node("noeud6", 560, 400, 50, "GRAY");
    Node noeud7 = new Node("noeud7", 30, 700, 50, "GRAY");     Node noeud8 = new Node("noeud8", 340, 700, 50, "GRAY");
    Node noeud9 = new Node("noeud9", 560, 700, 50, "GRAY");


    public LinkedList<Node> getListdenoeud() {
        return listdenoeud;
    }
    public void setListdenoeud(Node node){
        this.listdenoeud.add(node);
    }

    public LinkedList<Arc> getListdarc() {
        return listdarc;
    }
    public void setListdarc (Arc arc) {
        this.listdarc.add(arc);
    }


    public Graph (){
        listdenoeud = new LinkedList<>();
        this.listdenoeud.add(noeud1);   this.listdenoeud.add(noeud2);
        this.listdenoeud.add(noeud3);   this.listdenoeud.add(noeud4);
        this.listdenoeud.add(noeud5);   this.listdenoeud.add(noeud6);
        this.listdenoeud.add(noeud7);   this.listdenoeud.add(noeud8);
        this.listdenoeud.add(noeud9);

        listdarc = new LinkedList<>();
    }
    public void suprimNode(Node nodexp){
        for(Arc arc : this.getListdarc()){
            if(nodexp.egalnode(arc.getNoeudefin()) || nodexp.egalnode(arc.getNoeudorigin())) {
                listdarc.remove(arc);
                listdenoeud.remove(nodexp);
            }
        }
    }

    public void addNode(Node nodexp){
        boolean col = false;
        //boolean add = false;

        for(Node node : this.getListdenoeud()){

            if (!node.supnode(nodexp)){         }
            else {
                col = true;
                Log.e("xx","je dit supperposer");    break;      }
        }
        if (!col){
            this.listdenoeud.add(nodexp);
            //add = true;
        }
        //return  add;
    }

    public Node Nodeproche(Node nodexp){
        boolean col = false;
        Node nodetemp = new Node();
        for(Node node : this.getListdenoeud()){

            if (!node.supnode(nodexp)){
                Log.e("sup","pas de supperposer");
            }else {
                col = true;
                nodetemp = node;
                Log.e("sup","supperposer");
                break;
            }
        }
        return nodetemp;
    }

    public boolean nodeproch (Node nodexp){
        boolean existe = false;
        for(Node node : this.getListdenoeud()){
            if( nodexp.getX() >= (node.getX() - (node.getRay()+nodexp.getRay())) && nodexp.getX() <= (node.getX() + node.getRay()) &&
                    nodexp.getY() >= (node.getY() + (node.getRay()+nodexp.getRay())) && node.getY() <= (node.getY() + (node.getRay()+nodexp.getRay()))){
                existe = true;
                Log.e("existe","il existe un noeud " + existe);
            }
        }
        return existe;
    }
    public Node nodexiste (int x, int y){
        //Log.e("cordonnée"," je suis dans la classe nodexiste ");
        Node temp = new Node();
        for(Node node : this.getListdenoeud()){
            //Log.e("cordonnée"," les cord X et Y : " +node.getX()+ " et "+ x+ " ,,, " + node.getY()+ " et "+ y);
            if( x >= (node.getX() - node.getRay()) && x <= (node.getX()+node.getRay())) {
                //Log.e("cordonnée"," premiere boucle if");
                //Log.e("cordonnée"," les cord X et Y : " +node.getX()+ " et "+ x);
                if (y >= (node.getY() - node.getRay()) && y <= (node.getY()+node.getRay())){
                    //Log.e("cordonnée"," deuxieme boucle if");
                    //Log.e("cordonnée"," les cord X et Y : " +node.getY()+ " et "+ y);
                    temp = node;
                }
            }
            else {
                //Log.e("cordonnée"," la boucle else");
                //Log.e("cordonnée","il n'existe pas de noeud ");
            }
        }
        return temp;
    }


    public void addArc(Arc arc){

        this.listdarc.add(arc);
    }
    public void misajourarc(LinkedList<Arc> newlistdarc){
        this.listdarc = newlistdarc;
    }
}