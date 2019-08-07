package Classes;

import javax.swing.ImageIcon;

public class Player extends Objeto {

    ImageIcon imgPlayerIcon = new ImageIcon(getClass().getResource("nave.png"));
    private int vida;

    public Player() {
        super(50, 300, 100, 70, 10);
        vida = 3;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
