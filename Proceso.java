package estrada.leon.rafael.pongrafa;

import java.util.Random;
//1013.1 y
//712 x
public class Proceso {
    private float x = 5;
    private float y = 5;
    private float x2 = 2;
    private float y2 = 2;
    private float puntuacion1 = 0;
    private float puntuacion2 = 0;
    private float a = 0;
    private float a2 = 2;
    private int contador=1;
    private Random r = new Random();

    public void move(float Recx) {
        a += a2;
        x += x2;
        y += y2;
        if (x <= 0) { // Si la bolita toca la pared izquierda

            x = 0;
            x2 = -x2;
        }
        if (x >= 700) { //Si la bolita toca la pared derecha
            x = 700;
            x2 = -x2;
        }

        if (y <= 20) { //Si la bolita llega a la parte superior
            y = 20;
            y2 = -y2;
            if (x < a | x > a + 200) {
                puntuacion2 += 5;

            }

        }

        if (y >= 853) { //Si la bolita llega a la parte inferior
            if (x >= Recx-5 && x <= Recx + 200) {
                y = 853;
                y2 = -y2;
            } else {
                y = 853;
                y2 = -y2;

            }
            if (x < Recx-5 | x > Recx + 200) {
                puntuacion1 += 5;
            }
        }

        /*if (puntuacion2/30 >= contador) {
            if (x2 > 0  )
                x2 +=1;
            else
                x2 -=1;
            if (y2 > 0)
                y2 = 4;
            else
                y2 = -4;
            contador++;
        }*/
        if (a <= 0) {
            a = 0;
            a2 = r.nextInt(3);
        } else if (a >= 570) {
            a = 570;
            a2 = -r.nextInt(3);
        }


    }


    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getPuntuacion1() {
        return this.puntuacion1;
    }

    public float getPuntuacion2() {
        return this.puntuacion2;
    }

    public float geta() {
        return this.a;
    }
}
