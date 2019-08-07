package Classes;

import javax.swing.ImageIcon;

public class Chefao extends Objeto {

    ImageIcon imgChefeIcon;
    private int vida;

    public Chefao() {
        super(50, 300, 100, 70, 10);
        vida = 50;
        imgChefeIcon = new ImageIcon(getClass().getResource("boss.png"));
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
