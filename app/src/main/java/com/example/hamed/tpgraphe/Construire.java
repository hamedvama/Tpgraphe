package com.example.hamed.tpgraphe;
        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.os.Build;
        import android.support.annotation.RequiresApi;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Toast;

    public class Construire extends View {

    private  Paint  paint = new Paint();
    private int abs, ord;

    Node noeud1 = new Node("noeud1", 120, 100, 50, "GRAY");
    Node noeud2 = new Node("noeud1", 340, 100, 50, "GRAY");
    Node noeud3 = new Node("noeud1", 560, 100, 50, "GRAY");
    Node noeud4 = new Node("noeud1", 120, 400, 50, "GRAY");
    Node noeud5 = new Node("noeud1", 340, 400, 50, "GRAY");
    Node noeud6 = new Node("noeud1", 560, 400, 50, "GRAY");
    Node noeud7 = new Node("noeud1", 120, 700, 50, "GRAY");
    Node noeud8 = new Node("noeud1", 340, 700, 50, "GRAY");
    Node noeud9 = new Node("noeud1", 560, 700, 50, "RED");

    public Construire(Context context) {
        super(context);
    }

    public void dessiner(int A, int B, Canvas canvas) {
        Node noeud = new Node("nodeA",A,B,50,"RED");
        canvas.drawCircle(noeud.getX(),noeud.getY(),noeud.getRay(),paint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onDraw(final Canvas canvas) {

        canvas.drawColor(Color.MAGENTA);
        canvas.drawCircle(noeud1.getX(),noeud1.getY(),noeud1.getRay(), noeud1.getPaint());
        canvas.drawCircle(noeud2.getX(),noeud2.getY(),noeud2.getRay(), paint);
        canvas.drawCircle(noeud3.getX(),noeud3.getY(),noeud3.getRay(), paint);
        canvas.drawCircle(noeud4.getX(),noeud4.getY(),noeud4.getRay(), paint);
        canvas.drawCircle(noeud5.getX(),noeud5.getY(),noeud5.getRay(), paint);
        canvas.drawCircle(noeud6.getX(),noeud6.getY(),noeud6.getRay(), paint);
        canvas.drawCircle(noeud7.getX(),noeud7.getY(),noeud7.getRay(), paint);
        canvas.drawCircle(noeud8.getX(),noeud8.getY(),noeud8.getRay(), paint);
        canvas.drawCircle(noeud9.getX(),noeud9.getY(),noeud9.getRay(), noeud9.getPaint());

        this.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View myView, MotionEvent event) {
                                        int action = event.getAction();

                                        if (action==MotionEvent.ACTION_UP)
                                        {
                                            int x = (int) event.getX();
                                            int y = (int) event.getY();
                                            Toast.makeText(getContext(),"x = " +String.valueOf(x) + "," + "  y = " +String.valueOf(y) ,Toast.LENGTH_SHORT).show();
                                            //Node newnode = new Node("newnode",abs,ord,50,"GRAY");
                                            //canvas.drawCircle(newnode.getX(),newnode.getY(),newnode.getRay(),newnode.getPaint());
                                            dessiner(x, y, canvas);
                                        }

                                        if (action==MotionEvent.ACTION_MOVE){
                                            abs = (int) event.getX();
                                            ord = (int) event.getY();
                                            Toast.makeText(getContext(),"x = " +String.valueOf(abs) + "," + "  y = " +String.valueOf(ord) ,Toast.LENGTH_SHORT).show();
                                        }
                                        return true;
                                    }
                                }
        );

    }

}