package Classes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NaveInimiga {

    JLabel imgInimigo;
    int x, y;

    public NaveInimiga(int x, ImageIcon icon) {
        this.x = x;
        y = 100;
        imgInimigo = new JLabel(icon);
    }

    public void moveY() {
        y += 7;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JLabel getLabel() {
        return imgInimigo;
    }
}
