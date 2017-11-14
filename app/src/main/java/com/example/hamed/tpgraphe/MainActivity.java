package com.example.hamed.tpgraphe;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.MotionEvent;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawableGraph Dgraph;
    Graph graph = new Graph();
    ImageView img;
    Node nodedown, nodeup , nodetemp1, nodetemp2;
    Arc arc;
    int Xmove,Ymove, Xdown, Ydown, Xup,Yup;
    boolean selectnodedown = false, selectnodeup = false;
    boolean apdown =false, apup=false, apmove = false, add = false;
    long timedown = 0, timedappuie;
    EditText editText;
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
                        //Log.e("cordonnée"," le X Down : "+ Xdown+ " le Y Down : " + Ydown);

                        nodedown = new Node();
                        nodedown = graph.nodexiste(Xdown,Ydown);//recupere le noeud sur lequel on a cliqué ou un noeud vide
                        Log.e("cordonnée"," le noeud selectionner au down " + nodedown.toString()+" son X "
                                +nodedown.getX()+ " son Y "+ nodedown.getY()+ " Etiquette "+ nodedown.getEtiq()+
                                " couleur " + nodedown.getColor());
                        timedown = System.currentTimeMillis(); //recupere le temps du systeme au moment du down
                        //Log.e("cordonnée","le temps" + timedown);

                    case MotionEvent.ACTION_UP :
                        apup = true;
                        Xup = (int) event.getX();
                        Yup = (int) event.getY();
                        Log.e("cordonnée"," le X UP : "+ Xup+ " le Y UP : " + Yup);
                        if (Xdown == Xup && Ydown == Yup ) {
                            timedappuie = System.currentTimeMillis() - timedown;
                            Log.e("cordonnée","le temps " + timedappuie);
                        }
                        nodeup = new Node();
                        nodeup = graph.nodexiste(Xup,Yup);
                        Log.e("cordonnée"," le noeud selection au up " + nodeup.toString()+" son X "
                                +nodeup.getX()+ " son Y "+ nodeup.getY()+ " Etiquette "+ nodedown.getEtiq()+
                                " couleur " + nodedown.getColor());
                        if(nodedown.getX()== 0 && nodeup.getX() ==0 && nodedown.getY()== 0 && nodeup.getY() ==0){
                            Log.e("cordonnée"," pas de noeud selectionner donc on crée un noeud");
                            if (Xdown == Xup && Ydown == Yup ) {
                                nodetemp2 = new Node(Xup,Yup);
                                graph.addNode(nodetemp2);
                                Dgraph.setGraph(graph);
                                img.setImageDrawable(Dgraph);
                                img.invalidate();
                            }
                        }

                        if (Xdown == Xup && Ydown == Yup && timedappuie > 500 ){
                            Toast.makeText(img.getContext(),"noeud selection",Toast.LENGTH_SHORT).show();
                        }

                        if(nodedown.getX()!=0 && nodedown.getY()!=0 && nodeup.getX()!=0 && nodeup.getY()!=0){
                            arc = new Arc(nodedown,nodeup);
                            graph.addArc(arc);
                            Dgraph.setGraph(graph);
                            img.setImageDrawable(Dgraph);
                            img.invalidate();
                        }

                        if(nodedown.getX()!=0 && nodedown.getY()!=0 && nodeup.getX()==0 && nodeup.getY()==0){
                            nodetemp1 = new Node();
                            nodetemp1 = graph.nodexiste(Xmove,Ymove);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.etiq:

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
