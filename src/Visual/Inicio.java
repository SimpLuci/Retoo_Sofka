/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RYZEN
 */
public class Inicio extends JFrame{
     private JLabel p;
     private JButton Btcontinuar;
     private JPanel panel1;
     private JDesktopPane dpnEscritorio;
     
     
    public Inicio() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        p = new JLabel("Bienvenido", JLabel.CENTER);
        p.setFont(new Font("arial", Font.PLAIN, 35));
        panel1 = new JPanel();
        Btcontinuar = new JButton("Jugar");
        dpnEscritorio = new DesktopConFondo(); 
        ((DesktopConFondo) dpnEscritorio).setImagen("/Imagenes/Fondo.jpg");
        setContentPane(dpnEscritorio);
        panel1.setLayout(null);
        getContentPane().add(panel1);
        add(p);
        add(Btcontinuar);
        p.setBounds(300,100,200,50);
        Btcontinuar.setBounds(150,380,500,50);
        
        Btcontinuar.addActionListener(this::BtcontinuaractionPerformed);
    }
    
    public void BtcontinuaractionPerformed(ActionEvent e) {
        VPreguntas open = new VPreguntas();
        this.setVisible(false);
        open.setVisible(true);
        
    }
}
