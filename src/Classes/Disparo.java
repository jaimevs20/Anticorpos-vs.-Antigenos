package Classes;

import javax.swing.ImageIcon;

public class Disparo extends Objeto {

    ImageIcon imgChefeIcon;

    public Disparo(Objeto a) {
        super(a.getX() + 20, a.getY(), 50, 25, 30);
        imgChefeIcon = new ImageIcon(getClass().getResource("tiro.png"));
    }

}
