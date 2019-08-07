package TelaInicial;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.net.URL;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Classes.Dados;
import Tela.Janela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private int Largura, Altura;
    String nome = new String();

    AudioClip musica;

    Dados dados;

    ImageIcon fundo = new ImageIcon(getClass().getResource("bg.png"));
//    ImageIcon fundoRanking = new ImageIcon(getClass().getResource("telaRankin.png"));
    ImageIcon voltar = new ImageIcon(getClass().getResource("voltar.png"));
    ImageIcon pressStart = new ImageIcon(getClass().getResource("press2.png"));
    ImageIcon lNomeIcon = new ImageIcon(getClass().getResource("LNome.png"));
    ImageIcon enredo = new ImageIcon(getClass().getResource("ENREDO.png"));
    ImageIcon novoJogo = new ImageIcon(getClass().getResource("nJogadorIcon.png"));
   // ImageIcon rankingImgIcon = new ImageIcon(getClass().getResource("rankingIcon.png"));
//    ImageIcon logo = new ImageIcon(getClass().getResource("logoGame.png"));
    ImageIcon playerA = new ImageIcon(getClass().getResource("nave01N.png"));
    ImageIcon inimigoA = new ImageIcon(getClass().getResource("inimigoA.png"));
    ImageIcon playerB = new ImageIcon(getClass().getResource("nave01NB.png"));
    ImageIcon inimigoB = new ImageIcon(getClass().getResource("inimigo04.png"));
    ImageIcon playerAB = new ImageIcon(getClass().getResource("playerAB.png"));
    ImageIcon inimigoAB = new ImageIcon(getClass().getResource("inimigoAB.png"));

    JLabel bg = new JLabel(fundo);
    //JLabel logoGame = new JLabel(logo);
    JLabel startImg = new JLabel("ESCOLHA O SEU ANTICORPO");
   // JLabel rankingImg = new JLabel(rankingImgIcon);
    JLabel press = new JLabel(pressStart);
    JButton tipoPlayerA = new JButton(playerA);
    JButton tipoPlayerB = new JButton(playerB);
    JButton tipoPlayerC = new JButton(playerAB);

    JButton btEnredo = new JButton("ENREDO");
    JButton[] players = new JButton[3];

    JLabel caixa = new JLabel(nome);
    JLabel[] nomePlayer = new JLabel[5];
    JLabel[] scorePlayer = new JLabel[5];
    JLabel[] posicao = new JLabel[5];
    JLabel scoreImg = new JLabel("Score");
    JLabel nomePlayerImg = new JLabel("Nome");

    int eCode = 0;

    boolean goRanking = true, goJogo = false, digitandoNome = false;
    int i = 0;

    public TelaInicial() {
        super("Anticorpo vs Antígenos");
        Largura = 600;
        Altura = 700;
        players[0] = tipoPlayerA;
        players[1] = tipoPlayerB;
        players[2] = tipoPlayerC;
        try {
            dados = new Dados();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Font font = new Font("impact", Font.PLAIN, 30);
        Font font1 = new Font("impact", Font.PLAIN, 18);
        caixa.setFont(font1);
        caixa.setForeground(Color.white);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Largura, Altura);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        press.setVisible(false);
        press.setBounds(350, 40, 222, 36);
        //tipoPlayerB.setBounds();
        caixa.setVisible(false);
        caixa.setBounds(288, 600, 398, 48);
        startImg.setBounds(190, 600, 398, 48);
        startImg.setFont(font);
        startImg.setForeground(Color.LIGHT_GRAY);
        caixa.setVisible(true);
        // logoGame.setBounds(30, 150, 490, 364);
        bg.setBounds(-3, -15, Largura, Altura);
        int x = 300, y = 500;

        for (int i = 0; i < players.length; i++) {
            players[i].setVisible(false);
            players[i].setBounds(x, y, 42, 52);
            add(players[i]);

            x += 50;
            players[i].setVisible(true);
        }
        btEnredo.setBounds(0,30,100,20);
        add(btEnredo);
        btEnredo.setVisible(true);
        //add(tipoPlayerB);
        // add(caixa);
        //  add(press);
        add(startImg);
        //add(select);
        //add(logoGame);
        add(bg);
        sound("inicio");

        new menu().start();
        
        acaoBotao(tipoPlayerA, playerA, inimigoA);
        acaoBotao(tipoPlayerB, playerB, inimigoB);
        acaoBotao(tipoPlayerC, playerAB, inimigoAB);

        tipoPlayerA.setToolTipText("Anticorpo anti-B - Combate Antígeno B");
        tipoPlayerB.setToolTipText("Anticorpo anti-A - Combate Antígeno A");
        tipoPlayerC.setToolTipText("Anicorpo anti-O - Combate Antígeno O ");

        //acaoBotao(tipoPlayerB,playerB);   
        btEnredo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaEnredo();
            }
        });
    }

    public void acaoBotao(JButton b, ImageIcon img, ImageIcon inimigo) {

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Janela novoJogo = null;
                try {
                    novoJogo = new Janela(img, img, img, inimigo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
                novoJogo.addNave();
                stopSound();
            }
        });
    }

    public void acao() {
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {

                if (!digitandoNome) {
                    if (e.getKeyCode() == 87) {
                        if (goRanking) {
                            eCode = 0;
                        }
                    }
                    if (e.getKeyCode() == 83) {
                        eCode = 1;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!digitandoNome) {
                    if (e.getKeyCode() == 32) {
                        if (eCode == 0) {
                            stopSound();
                            sound("disparo");
                            sound("inicio");
                            if (goJogo) {
                                goRanking = true;
                                goJogo = false;
                                digitandoNome = false;
                                eCode = 0;
                                i = 0;
                                stopSound();
                                Dados.nome = nome;
                                Janela novoJogo = null;
                                try {
                                    novoJogo = new Janela(playerA, playerA, playerA, inimigoA);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                setVisible(false);
                                novoJogo.addNave();

                            } else if (goRanking) {
                                startImg.setVisible(false);
//                                rankingImg.setVisible(false);
                                tipoPlayerA.setVisible(true);
                                caixa.setVisible(true);
                                digitandoNome = true;

                               /* bg.setIcon(enredo);
                                Janela novoJogo = new Janela();
							setVisible(false);8
							novoJogo.addNave();*/
                            }
                        } else if (eCode == 1) {
                            if (goRanking) {
                                stopSound();
                                sound("disparo");
                                //sound("inicio");
//                                logoGame.setVisible(false);
                                //mostraRanking(true);
//                                bg.setIcon(fundoRanking);
                                startImg.setVisible(false);
//                                rankingImg.setVisible(false);
                               // rankingImg.setIcon(voltar);
                               // rankingImg.setBounds(150, 650, 246, 51);
                                goRanking = false;
                            } else {
                                stopSound();
                                sound("disparo");
                                //sound("inicio");
                           //     logoGame.setVisible(true);
                                //mostraRanking(true);
                                bg.setIcon(fundo);
                                startImg.setVisible(true);
                               // rankingImg.setVisible(false);
                               // rankingImg.setIcon(rankingImgIcon);
                                //rankingImg.setBounds(100, 650, 229, 41);
                                goRanking = true;
                            }
                        }
                    }
                } else {
                    int n = e.getKeyCode();
                    if ((n >= 65 && n <= 90 && nome.length() < 17)) {
                        nome += (char) n;
                        caixa.setText(nome);
                    } else if (n == 8 && nome.length() > 0) {
                        nome = nome.substring(0, nome.length() - 1);
                        caixa.setText(nome);
                    } else if ((n == 32 || n == 10) && nome.length() > 0) {
                        sound("disparo");
                        tipoPlayerA.setVisible(false);
                        caixa.setVisible(false);
//                        logoGame.setVisible(false);
                        bg.setIcon(enredo);
                        press.setVisible(false);
                        digitandoNome = false;
                        goJogo = true;
                    }
                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public class menu extends Thread {

        public void run() {
            while (true) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                animacao();
            }
        }
    }

    public void animacao() {
        if (!goJogo && !digitandoNome) {
            if (eCode == 0) {
               // rankingImg.setVisible(true);
                if (i % 2 == 0) {
                    startImg.setVisible(true);
                } else {
                    startImg.setVisible(false);
                }
                i++;
                if (i > 100) {
                    i = 0;
                }
            }

            if (eCode == 1) {
                if (goRanking) {
                    startImg.setVisible(true);
                }
                if (i % 2 == 0) {
                //    rankingImg.setVisible(true);
                } else {
              //      rankingImg.setVisible(false);
                }
                i++;
                if (i > 100) {
                    i = 0;
                }
            }
        } else if (!digitandoNome) {
            if (i % 2 == 0) {
                press.setVisible(true);
            } else {
                press.setVisible(false);
            }
            i++;
            if (i > 100) {
                i = 0;
            }
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
                musica = Applet.newAudioClip(getClass().getResource("/abertura.wav"));
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
