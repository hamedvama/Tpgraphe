package com.example.hamed.tpgraphe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.*;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    DrawableGraph Dgraph;
    Graph graph = new Graph();
    ImageView img;
    Node nodedown, nodeup , nodetemp;
    Arc arc;
    int Xmove,Ymove, Xdown, Ydown, Xup,Yup;
    boolean selectnodedown = false, selectnodeup = false;
    boolean apdown =false, apup=false, apmove = false, add = false;
    long timedown = 0, timedappuie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dgraph = new DrawableGraph();
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView);
        Dgraph.setGraph(graph);
        img.setImageDrawable(Dgraph);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN :
                        apdown = true;
                        Xdown = (int) event.getX();
                        Ydown = (int) event.getY();
                        Log.e("cordonnée"," le X Down : "+ Xdown+ " le Y Down : " + Ydown);

                        nodedown = new Node();
                        nodedown = graph.nodexiste(Xdown,Ydown);
                        Log.e("cordonnée"," le noeud selectionner au down " + nodedown.toString()+" son X "
                                +nodedown.getX()+ " son Y "+ nodedown.getY()+ " Etiquette "+ nodedown.getEtiq()+
                                " couleur " + nodedown.getColor());
                        timedown = System.currentTimeMillis();
                        Log.e("cordonnée","le temps" + timedown);

                    case MotionEvent.ACTION_UP :
                        apup = true;
                        Xup = (int) event.getX();
                        Yup = (int) event.getY();
                        Log.e("cordonnée"," le X UP : "+ Xup+ " le Y UP : " + Yup);
                        if (Xdown == Xup && Ydown == Yup ) {
                            timedappuie = System.currentTimeMillis() - timedown;
                        }
                        nodeup = new Node();
                        nodeup = graph.nodexiste(Xup,Yup);
                        Log.e("cordonnée"," le noeud selection au up " + nodeup.toString()+" son X "
                                +nodeup.getX()+ " son Y "+ nodeup.getY()+ " Etiquette "+ nodedown.getEtiq()+
                                " couleur " + nodedown.getColor());
                        if(nodedown.getX()== 0 && nodeup.getX() ==0 && nodedown.getY()== 0 && nodeup.getY() ==0){
                            Log.e("cordonnée"," pas de noeud selectionner donc on crée un noeud");
                            Log.e("cordonnée","le temps " + timedappuie);
                            if (Xdown == Xup && Ydown == Yup ) {
                                graph.addNode(new Node(Xdown,Ydown));
                                Dgraph.setGraph(graph);
                                img.setImageDrawable(Dgraph);
                                img.invalidate();
                            }

                        }
                        /*if (Xdown == Xup && Ydown == Yup && timedappuie > 500 ){
                            Log.e("supprime", " le time appuis "+ timedappuie);
                            graph.supnode(nodedown);
                        }*/
                        if(nodedown.getX()!=0 && nodedown.getY()!=0 && nodeup.getX()!=0 && nodeup.getY()!=0){
                            arc = new Arc(nodedown,nodeup);
                            graph.addArc(arc);
                            Dgraph.setGraph(graph);
                            img.setImageDrawable(Dgraph);
                            img.invalidate();
                        }
                        if(nodedown.getX()!=0 && nodedown.getY()!=0 && nodeup.getX()==0 && nodeup.getY()==0){
                            nodetemp = new Node();
                            nodetemp = graph.nodexiste(Xmove,Ymove);
                            nodedown.misajour(Xmove,Ymove);
                            Log.e("cordonnée"," je fais la mise a jour");
                            Dgraph.setGraph(graph);
                            img.setImageDrawable(Dgraph);
                            img.invalidate();

                        }
                        break;

                    case MotionEvent.ACTION_MOVE :
                        apmove = true;
                        Xmove = (int) event.getX();
                        Ymove = (int) event.getY();
                        Log.e("cordonnée"," je move ; le X Move : "+ Xmove+ " le Y Move : " + Ymove);
                }
                return true;
            }
        });
    }
}
