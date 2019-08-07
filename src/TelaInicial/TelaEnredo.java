package TelaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class TelaEnredo extends JFrame{
    ImageIcon fundo = new ImageIcon(getClass().getResource("bgEnredo.png.jpg"));
    JLabel bg = new JLabel(fundo);
    JButton botaoAntigeno = new JButton("ANTÍGENOS");
    JButton inicio = new JButton("VOLTAR");
    TelaEnredo(){
        super("ENREDO");
        
        bg.setBounds(-3, -15, 800,600);
       // setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        add(bg);
        botaoAntigeno.setBounds(100,0,100,20);
        inicio.setBounds(0,0,100,20);
        botaoAntigeno.setVisible(true);
        inicio.setVisible(true);
        
        add(botaoAntigeno);
        add(inicio);
        
        botaoAntigeno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaEnredo1();
            }
        });
        
        inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaInicial();
            }
        });
    }
}
