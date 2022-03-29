/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lucy
 */
public class Inpreguntas extends JFrame{
    private JLabel p;
    private JLabel p1;
    private JLabel R1;
    private JLabel R2;
    private JLabel R3;
    private JLabel R4;
    private JRadioButton T1;
    private JRadioButton T2;
    private JRadioButton T3;
    private JRadioButton T4;
    private JTextArea Ap;
    private JTextArea Ar1;
    private JTextArea Ar2;
    private JTextArea Ar3;
    private JTextArea Ar4;
    private JButton Btcontinuar;
    private JButton Btsalir;
    private JComboBox Lista;
    private JDesktopPane dpnEscritorio;
    private JPanel panel1;
    public  Inpreguntas () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //tamaño de la ventana
        this.setSize(500, 600);
        // Iniciamos en mitad de pantalla
        this.setLocationRelativeTo(null);
        // iniciamos las variables
        p = new JLabel("Ingrese la pregunta", JLabel.CENTER);
        p1 = new JLabel("¿Que tipo de dificultad tiene?", JLabel.CENTER);
        R1 = new JLabel("Ingrese la respuesta", JLabel.CENTER);
        R2 = new JLabel("Ingrese la respuesta", JLabel.CENTER);
        R3 = new JLabel("Ingrese la respuesta", JLabel.CENTER);
        R4 = new JLabel("Ingrese la respuesta", JLabel.CENTER);
        Ap = new JTextArea();
        Ar1 = new JTextArea();
        Ar2 = new JTextArea();
        Ar3 = new JTextArea();
        Ar4 = new JTextArea();
        panel1 = new JPanel();
        Lista = new JComboBox();
        T1 = new JRadioButton();
        T2 = new JRadioButton();
        T3 = new JRadioButton();
        T4 = new JRadioButton();
        Lista.addItem("1");
	Lista.addItem("2");
	Lista.addItem("3");
        Lista.addItem("4");
	Lista.addItem("5");
        Btcontinuar = new JButton("Continuar");
        Btsalir = new JButton();
        // colocamos un icono al boton
        Btsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Erase.png")));
        //Damos fondo al escritorio
        dpnEscritorio = new DesktopConFondo(); 
        ((DesktopConFondo) dpnEscritorio).setImagen("/Imagenes/confi.jpg");
        setContentPane(dpnEscritorio);
        panel1.setLayout(null);
        //Añadimos al panel
        getContentPane().add(panel1);
        add(p);
        add(p1);
        add(R1);
        add(R2);
        add(R3);
        add(R4);
        add(T1);
        add(T2);
        add(T3);
        add(T4);
        add(Ap);
        add(Ar1);
        add(Ar2);
        add(Ar3);
        add(Ar4);
        add(Lista);
        add(Btcontinuar);
        add(Btsalir);
        //Hacemos un grupo para que trabajen en conjunto los radios
        ButtonGroup GRUPO = new ButtonGroup();
        GRUPO.add(T1);
        GRUPO.add(T2);
        GRUPO.add(T3);
        GRUPO.add(T4);
        //Ingresamos cordenadas
        p.setBounds(150,100,200,20);
        Ap.setBounds(150,130,200,20);
        p1.setBounds(150,160,200,20);
        Lista.setBounds(150,190,200,20);
        R1.setBounds(150,220,200,20);
        Ar1.setBounds(150,250,200,20);
        T1.setBounds(130,250,20,20);
        R2.setBounds(150,280,200,20);
        Ar2.setBounds(150,310,200,20);
        T2.setBounds(130,310,20,20);
        R3.setBounds(150,340,200,20);
        Ar3.setBounds(150,370,200,20);
        T3.setBounds(130,370,20,20);
        R4.setBounds(150,400,200,20);
        Ar4.setBounds(150,430,200,20);
        T4.setBounds(130,430,20,20);
        Btcontinuar.setBounds(150,480,200,20);
        Btsalir.setBounds(460,0,30,20);
        // accion de la lista al seleccionar 
        Lista.addActionListener(this::ListaactionPerformed);
        Btcontinuar.addActionListener(this::BtcontinuaractionPerformed);
        Btsalir.addActionListener(this::BtsaliractionPerformed);
    }
    
    public void ListaactionPerformed(ActionEvent e) {
        //	tf.setText(Lista.getSelectedItem().toString());
    }
    public void BtcontinuaractionPerformed(ActionEvent e) {
        String tf;
        tf=Lista.getSelectedItem().toString();
   
        try {
            System.out.println("el contenido de tf es"+tf);
                FileWriter fv = new FileWriter("preguntas/Preguntas"+tf+".txt", true);
                BufferedWriter bv = new BufferedWriter(fv);
                PrintWriter pv = new PrintWriter(bv);
                if (T1.isSelected()) {
                    pv.print(Ap.getText() + "|*" + Ar1.getText() + "|" + Ar2.getText() + "|" + Ar3.getText() + "|" + Ar4.getText() + "\n");
                    pv.close();
                } else if (T2.isSelected()) {
                    pv.print(Ap.getText() + "|" + Ar1.getText() + "|*" + Ar2.getText() + "|" + Ar3.getText() + "|" + Ar4.getText() + "\n");
                    pv.close();
                } else if (T3.isSelected()) {
                    pv.print(Ap.getText() + "|" + Ar1.getText() + "|" + Ar2.getText() + "|*" + Ar3.getText() + "|" + Ar4.getText() + "\n");
                    pv.close();
                } else if (T4.isSelected()) {
                    pv.print(Ap.getText() + "|" + Ar1.getText() + "|" + Ar2.getText() + "|" + Ar3.getText() + "|*" + Ar4.getText() + "\n");
                    pv.close();
                }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "No la da ");
        }
        Ap.setText("");
        Ar1.setText("");
        Ar2.setText("");
        Ar3.setText("");
        Ar4.setText("");
    }

    public void BtsaliractionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
