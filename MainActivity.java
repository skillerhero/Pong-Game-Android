package estrada.leon.rafael.pongrafa;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout MiLayout;
    ImageView BarraAbajo, BarraArriba,Bolita;
    TextView Puntuacion1,Puntuacion2,Nivel;
    float x=0,y=0,arribax=0,bolx=20,boly=20;
    private int contador=1,tiempo=6;
    int level=0;
    Proceso juego ;

   Intent intent ;
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            BarraAbajo.setX(x);
        }
    };
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bolita.setX(bolx);
            Bolita.setY(boly);
            Puntuacion1.setText(String.valueOf(juego.getPuntuacion1()));
            Puntuacion2.setText(String.valueOf(juego.getPuntuacion2()));
            Nivel.setText("Nivel: "+level);
        }
    };
    Handler handler3 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
         arribax=juego.geta();
         BarraArriba.setX(arribax);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        juego= new Proceso();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarraAbajo=findViewById(R.id.BarraAbajo);
        BarraArriba=findViewById(R.id.BarraArriba);
        Bolita=findViewById(R.id.Bolita);
        MiLayout=findViewById(R.id.MiLayout);
        Puntuacion1=findViewById(R.id.Puntuacion1);
        Puntuacion2=findViewById(R.id.Puntuacion2);
        Nivel=findViewById(R.id.Nivel);
        MiLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x=event.getX()-100;
                if(x>550){
                    x=550;
                }
                if(x<0){
                    x=0;
                }
                Runnable HiloBarraAbajo = new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0);
                    }
                };
                Thread Hilo1= new Thread(HiloBarraAbajo);
                Hilo1.start();
                return true;
            }
        });
        Runnable HiloPrincipal = new Runnable() {
            @Override
            public void run() {
                while(true){
                ciclo();
                if (level==5)
                    break;
                }
            }
        };
        Thread Hilo2= new Thread(HiloPrincipal);
        Hilo2.start();
        }
    public void ciclo() {
        level= (int)juego.getPuntuacion2();
        level=level/30;

        if (juego.getPuntuacion2()/30 > contador)
        {
            tiempo-=1;
            contador++;
        }

            handler3.sendEmptyMessage(0);
            handler2.sendEmptyMessage(0);
            juego.move(x);
            boly=juego.getY();
            bolx=juego.getX();
            long futureTime = System.currentTimeMillis() + tiempo; //Espera 10 miliseg
            while (System.currentTimeMillis() < futureTime) {
                synchronized (this) {
                    try {
                        wait(futureTime - System.currentTimeMillis());
                    } catch (Exception e) {
                    }
                }
            }

    }

}
