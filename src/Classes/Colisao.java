package Classes;

public class Colisao {

    public boolean colidiu(Objeto a, Objeto b) {
        int cont = 0;
        int a1 = a.getY() + a.getA(), a2 = a.getX() + a.getL(), a3 = a.getY() - a.getA(), a4 = a.getX() - a.getL(),
                b1 = b.getY() + b.getA(), b2 = b.getX() + b.getL(), b3 = b.getY() - b.getA(), b4 = b.getX() - b.getL();
        if (b1 >= a3 && b1 <= a1) {
            cont++;
        }
        if (b3 >= a3 && b3 <= a1) {
            cont++;
        }
        if (b2 <= a2 && b2 >= a4) {
            cont++;
        }
        if (b4 <= a2 && b4 >= a4) {
            cont++;
        }

        if (cont > 1) {
            return true;
        } else {
            return false;
        }
    }

}
