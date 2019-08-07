package Classes;

public class Objeto {

    private int x, y, l, a, velocidade;

    public Objeto(int x, int y, int l, int a, int velocidade) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.a = a;
        this.velocidade = velocidade;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getL() {
        return l;
    }

    public int getA() {
        return a;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getVelocidade() {
        return velocidade;
    }
}
