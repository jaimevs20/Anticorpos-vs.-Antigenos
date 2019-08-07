package Tela;

import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Classes.Dados;
import TelaInicial.TelaInicial;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

public class Janela extends JFrame {

    private static final long serialVersionUID = 1L;
    private int Largura, Altura, xNave = 290, yNave = 600, contTempo = 0;
    int vidaJogador, vidaChefe, contAbates, auxMorreu1, auxMorreu2;
    boolean morreu, jogando = true;
    String s;
    Dados dados;
    AudioClip musica;
    ImageIcon fundo = new ImageIcon(getClass().getResource("layout.jpg"));
    ImageIcon inimigo;
    ImageIcon tiro = new ImageIcon(getClass().getResource("tiro01.png"));
    ImageIcon jogadorX;
    ImageIcon imgVida = new ImageIcon(getClass().getResource("vida.png"));
    ImageIcon jDireita;
    ImageIcon jEsquerda;
    //JLabel boss = new JLabel(new ImageIcon(getClass().getResource("boss.png")));
    JLabel nave;
    JLabel espaco = new JLabel(fundo);
    JLabel vida = new JLabel(imgVida);
    JLabel vida1 = new JLabel(imgVida);
    JLabel vida2 = new JLabel(imgVida);
    JLabel vida3 = new JLabel(imgVida);
    JLabel vida4 = new JLabel(imgVida);
    JLabel vida5 = new JLabel(imgVida);
    JLabel score;
    ArrayList<JLabel> vidas = new ArrayList<JLabel>();
    ArrayList<Disparo> disparos = new ArrayList<Disparo>();
    ArrayList<NaveInimiga> inimigos = new ArrayList<NaveInimiga>();

    public Janela(ImageIcon jogadorX, ImageIcon jDireita, ImageIcon jEsquerda, ImageIcon inimigo) throws FileNotFoundException {
        super("Anticorpo vs Antígenos");

        JLabel nave = new JLabel(jogadorX);
        this.jogadorX = jogadorX;
        this.jDireita = jDireita;
        this.jEsquerda = jEsquerda;
        this.nave = nave;
        this.inimigo = inimigo;
        dados = new Dados();
        Largura = 600;
        Altura = 700;
        vidaChefe = 15;
        vidaJogador = 5;
        contAbates = 0;
        morreu = false;
        auxMorreu1 = 0;
        auxMorreu2 = 0;
        s = Integer.toString(contAbates);
        score = new JLabel(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Largura, Altura);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        //espaco.add(score);
        movimento();
        new moverInimigo().start();
    }

    //Leitura de teclado
    public void movimento() {
        addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 65 && xNave >= 20) {
                    xNave -= 6;
                    nave.setIcon(jEsquerda);
                    nave.setLocation(xNave, yNave);
                }
                if (e.getKeyCode() == 68 && xNave <= 550) {
                    xNave += 6;
                    nave.setIcon(jDireita);
                    nave.setLocation(xNave, yNave);
                }

            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 65) {
                    nave.setIcon(jogadorX);
                }
                if (e.getKeyCode() == 68) {
                    nave.setIcon(jogadorX);
                }
                if (e.getKeyCode() == 32) {
                    disparos.add(new Disparo(tiro));
                    invocar01();
                    sound("disparo");
                }

            }

            public void keyTyped(KeyEvent e) {

            }

        });
    }

    //Funcoes para movimentacao de objetos
    public void movimentarInimigo() {
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).moveY();
            inimigos.get(i).imgInimigo.setBounds(inimigos.get(i).x, inimigos.get(i).y, 40, 40);
            if (inimigos.get(i).getY() > 900) {
                inimigos.get(i).imgInimigo.setVisible(false);
                inimigos.remove(i);
            }
        }
    }

    public void moverTiro() {
        for (int i = 0; i < disparos.size(); i++) {
            disparos.get(i).moveY();
            disparos.get(i).imgDisparo.setBounds(disparos.get(i).x, disparos.get(i).y, 21, 18);
            if (disparos.get(i).y < -100) {
                disparos.get(i).imgDisparo.setVisible(false);
                disparos.remove(i);
            }
        }
    }

    //Funcoes para invocar objetos na tela
    public void invocar() {

        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).imgInimigo.setBounds(inimigos.get(i).x, inimigos.get(i).y, 50, 50);
            add(inimigos.get(i).imgInimigo);
        }
        add(espaco);
    }

    public void invocar01() {

        for (int i = 0; i < disparos.size(); i++) {
            disparos.get(i).imgDisparo.setBounds(disparos.get(i).x, disparos.get(i).y, 8, 12);
            add(disparos.get(i).imgDisparo);
        }
        add(espaco);
    }

    public void mostrarScore() {
        String s = Integer.toString(contAbates);

    }

    public void addNave() {
        espaco.setBounds(0, 0, 600, 700);
        nave.setBounds(xNave, yNave, 42, 52);
        Font font = new Font("impact", Font.PLAIN, 14);
        score.setFont(font);
        score.setForeground(Color.white);
        score.setBounds(510, 761, 20, 20);
        vidas.add(vida);
        vidas.add(vida1);
        vidas.add(vida2);
        vidas.add(vida3);
        vidas.add(vida4);

        vidas.get(0).setBounds(65, 763, 18, 20);
        vidas.get(1).setBounds(90, 763, 18, 20);
        vidas.get(2).setBounds(115, 763, 18, 20);
        vidas.get(3).setBounds(140, 763, 18, 20);
        vidas.get(4).setBounds(165, 763, 18, 20);
        add(score);
        add(vidas.get(0));
        add(vidas.get(1));
        add(vidas.get(2));
        add(vidas.get(3));
        add(vidas.get(4));
        add(nave);
        add(espaco);
        mostrarScore();
    }

    //Funcoes auxiliares
    public int getXAleatorio() {
        Random n = new Random();
        return n.nextInt(540) + 30;
    }

    public int getLargura() {
        return Largura;
    }

    public int getAltura() {
        return Altura;
    }

    public void setJogando() {
        jogando = true;
    }

    public boolean getJogando() {
        return jogando;
    }

    //Funcoes para checar se ocorreu alguma colisao entre objetos
    public void chegarColisao() {
        try {
            for (int i = 0; i < inimigos.size(); i++) {
                if (colidiu(nave, inimigos.get(i).imgInimigo)) {
                    vidaJogador--;
                    vidas.get(vidas.size() - 1).setVisible(false);
                    vidas.remove(vidas.size() - 1);
                    if (vidaJogador <= 0) {
                        Dados.pontos = contAbates;
                        dados.salvarScore();
                        setVisible(false);
                        TelaGameOver func = new TelaGameOver();
                        func.setVisible(true);
                        int op = JOptionPane.showConfirmDialog(null,"Deseja voltar ao menu? \n\n"
                                + "Sua pontuação: " + contAbates, "Anticorpos vs. Antígenos ", 0);
                        if (op == 0) {
                            func.dispose();
                            new TelaInicial();
                        } else {
                            System.exit(0);
                        }
                    }
                    inimigos.get(i).imgInimigo.setVisible(false);
                    inimigos.remove(i);
                    xNave = 290;
                    yNave = 600;
                    nave.setVisible(false);
                    nave.setLocation(xNave, yNave);
                    morreu = true;
                } else {
                    for (int j = 0; j < disparos.size(); j++) {
                        if (colidiu(disparos.get(j).imgDisparo, inimigos.get(i).imgInimigo)) {
                            contAbates++;
                            s = Integer.toString(contAbates);
                            score.setText(s);
                            disparos.get(j).imgDisparo.setVisible(false);
                            disparos.remove(j);
                            inimigos.get(i).imgInimigo.setVisible(false);
                            inimigos.remove(i);
                        }

                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public boolean colidiu(Component a, Component b) {
        int aX = a.getX();
        int aY = a.getY();
        int aL = a.getWidth();
        int aA = a.getHeight();
        int ladoEsquerdoA = aX;
        int ladoDireitoA = aX + aL;
        int ladoCimaA = aY;
        int ladoBaixoA = aY + aA;
        int cont = 0;
        int bX = b.getX();
        int bY = b.getY();
        int bL = b.getWidth();
        int bA = b.getHeight();
        int ladoEsquerdoB = bX;
        int ladoDireitoB = bX + bL;
        int ladoCimaB = bY;
        int ladoBaixoB = bY + bA;
        //System.out.println(ladoDireitoA+" "+ladoEsquerdoA+" "+ladoBaixoA+" "+ladoCimaA);
        //System.out.println(ladoDireitoB+" "+ladoEsquerdoB+" "+ladoBaixoB+" "+ladoCimaB);
        boolean colisao = false;

        boolean cDireita = false;
        boolean cEsquerda = false;
        boolean cBaixo = false;
        boolean cCima = false;

        if (ladoCimaA >= ladoCimaB && ladoCimaA <= ladoBaixoB) {
            cCima = true;
            cont++;
        }
        if (ladoBaixoA >= ladoCimaB && ladoBaixoA <= ladoBaixoB) {
            cBaixo = true;
            cont++;
        }
        if (ladoEsquerdoA >= ladoEsquerdoB && ladoEsquerdoA <= ladoDireitoB) {
            cEsquerda = true;
            cont++;
        }
        if (ladoDireitoA <= ladoDireitoB && ladoDireitoA >= ladoEsquerdoB) {
            cDireita = true;
            cont++;
        }
        int invadiu = 0;
        if (ladoCimaB == Altura) {
            invadiu++;
        }
        if (cont >= 2 && (!cCima || !cBaixo) && (!cEsquerda || !cDireita) || (invadiu > 0)) {
            colisao = true;
        } else if (cont > 2) {
            colisao = true;
        }

        /*if(colisao){
			System.out.println(ladoEsquerdoA+" "+ladoDireitoA+" "+ladoCimaA+" "+ladoBaixoA);
			System.out.println(ladoEsquerdoB+" "+ladoDireitoB+" "+ladoCimaB+" "+ladoBaixoB);
			if(cCima)
				System.out.println("cima");
			if(cBaixo)
				System.out.println("baixo");
			if(cEsquerda)
				System.out.println("esquerda");
			if(cDireita)
				System.out.println("direita");
		}*/
        return colisao;
    }

    //Classes Criadas
    public class moverInimigo extends Thread {

        public void run() {
            while (true) {
                try {
                    sleep(20);

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (contTempo == 0) {
                    inimigos.add(new NaveInimiga(getXAleatorio(), inimigo));
                    invocar();
                }
                contTempo++;

                if (contTempo == 200) {
                    contTempo = 0;
                }

                if (contTempo == 0) {
                    inimigos.add(new NaveInimiga(getXAleatorio(), inimigo));
                    invocar();
                }
                contTempo++;

                if (contTempo == 170) {
                    contTempo = 0;
                }

                if (morreu) {
                    if (auxMorreu1 < auxMorreu2 / 10) {
                        if (auxMorreu1 % 2 == 0) {
                            nave.setVisible(true);
                        } else {
                            nave.setVisible(false);
                        }
                        auxMorreu1++;
                    }
                    if (auxMorreu2 >= 100) {
                        nave.setVisible(true);
                        auxMorreu1 = 0;
                        auxMorreu2 = 0;
                        morreu = false;
                    }
                    auxMorreu2++;
                }

                movimentarInimigo();
                moverTiro();
                chegarColisao();

            }
        }
    }

    public class NaveInimiga {

        JLabel imgInimigo;
        int x, y;

        public NaveInimiga(int x, ImageIcon icon) {
            this.x = x;
            y = -200;
            imgInimigo = new JLabel(icon);
            imgInimigo.setBounds(this.x, y, 100, 100);
            add(imgInimigo);
        }

        public void moveY() {
            y += 3;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public class Disparo {

        JLabel imgDisparo;
        int x, y;

        public Disparo(ImageIcon icon) {
            this.x = xNave + 10;
            y = yNave - 10;
            imgDisparo = new JLabel(icon);
            imgDisparo.setBounds(this.x, y, 12, 12);
        }

        public void moveY() {
            y -= 4;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public void sound(String nome) {
        try {
            if (nome == "disparo") {
                URL url = getClass().getResource("/disparo.wav");
                musica = Applet.newAudioClip(url);
                musica.play();
            }
            if (nome == "inicio") {
                URL url = getClass().getResource("/aberturaGam.wav");
                musica = Applet.newAudioClip(url);
                musica.play();
                musica.loop();
            }

        } catch (Exception p) {
            System.out.println("not found");
        }
    }

    public void stopSound() {
        musica.stop();
    }
}
