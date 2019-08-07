/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class TelaGameOver extends JFrame{
    ImageIcon fundoGameOver = new ImageIcon(getClass().getResource("Tgameover.png"));
    JLabel gameOver = new JLabel(fundoGameOver);
    
    public TelaGameOver(){
        gameOver.setVisible(true);
        gameOver.setBounds(0,0,736,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,736, 550);
        setResizable(false);
        setLayout(null);
        //setLocationRelativeTo(null);
        setVisible(true);
        add(gameOver);
    }
}
