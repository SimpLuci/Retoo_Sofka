/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Paquetito.Jugador;
import Paquetito.Preguntas;
import Paquetito.Ronda;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import jdk.jfr.events.FileReadEvent;
import static jdk.nashorn.internal.objects.NativeMath.random;
import static sun.net.util.IPAddressUtil.scan;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author Cristian Camilo Pelaez Bedoya (Lucy)
 */
public class VPreguntas extends JFrame {

    private ButtonGroup GRUPO;
    private JRadioButton T1;
    private JRadioButton T2;
    private JRadioButton T3;
    private JRadioButton T4;
    private JButton Btcontinuar;
    private JButton Btconfigurar;
   
    private JLabel Pregunta;
    private JLabel Dinero;
    private JDesktopPane dpnEscritorio;
    private JPanel panel1;
    Preguntas p1 = new Preguntas();
    Ronda R1 = new Ronda();
    Jugador J1 = new Jugador();
    ArrayList<Preguntas> D1 = new ArrayList<Preguntas>();
    ArrayList<Preguntas> D2 = new ArrayList<Preguntas>();
    ArrayList<Preguntas> D3 = new ArrayList<Preguntas>();
    ArrayList<Preguntas> D4 = new ArrayList<Preguntas>();
    ArrayList<Preguntas> D5 = new ArrayList<Preguntas>();
    public VPreguntas() {

        //a es igual a un contador para ir cambiando las preguntas y las etapas 
        //Medida de la ventana
        this.setSize(800, 600);
        //ingresamos las preguntas y posibles respuestas 
        
        //Iniciar la ventana en la mitad del escritorio
        this.setLocationRelativeTo(null);
        // iniciamos las variables para trabajar
        
        Pregunta = new JLabel();
        Dinero = new JLabel();
        Pregunta.setFont(new Font("arial", Font.PLAIN, 30));
        T1 = new JRadioButton();
        T1.setFont(new Font("arial", Font.PLAIN, 20));
        T2 = new JRadioButton(); 
        T2.setFont(new Font("arial", Font.PLAIN, 20));
        T3 = new JRadioButton(); 
        T3.setFont(new Font("arial", Font.PLAIN, 20));
        T4 = new JRadioButton();
        T4.setFont(new Font("arial", Font.PLAIN, 20));
        Btcontinuar = new JButton("Continuar");
        Btconfigurar = new JButton();
        Btconfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Application.png")));
        
        llenar();
        int tam ;
        tam  = (int) (Math.random()*(D1.size()-1)) + 1;
        
        p1.setPR1(D1.get(tam -1).getPR1());
        p1.setR1(D1.get(tam -1).getR1());
        p1.setR2(D1.get(tam -1).getR2());
        p1.setR3(D1.get(tam -1).getR3());
        p1.setR4(D1.get(tam -1).getR4());
        Pregunta.setText("<html>"+p1.getPR1()+"<html>");
        Dinero.setText("<html> Tienes : \n$ "+String.valueOf(J1.getDinero())+"<html>");
        T1.setText((p1.getR1()).replace("*", ""));
        T2.setText((p1.getR2()).replace("*", ""));
        T3.setText((p1.getR3()).replace("*", ""));
        T4.setText((p1.getR4()).replace("*", ""));
        //Agrupamos los radio buttom para que trabajen en conjunto
        GRUPO = new ButtonGroup();
        GRUPO.add(T1);
        GRUPO.add(T2);
        GRUPO.add(T3);
        GRUPO.add(T4);
        //Colocamos fondo   
        dpnEscritorio = new DesktopConFondo(); 
        ((DesktopConFondo) dpnEscritorio).setImagen("/Imagenes/Fondo.jpg");
        setContentPane(dpnEscritorio);
        //finalizar ejecucion con el cierre
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //creamos y añadimos al panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        getContentPane().add(panel1);
        add(Pregunta);
        add(Dinero);
        add(T1);
        add(T2);
        add(T3);
        add(T4);
        add(Btcontinuar);
        add(Btconfigurar);
        //ubicamos en la ventana
        Dinero.setBounds(630, 0, 100, 50);
        Pregunta.setBounds(200, 100, 400, 100);
        T1.setBounds(200, 250, 400, 50);
        T2.setBounds(200, 290, 400, 50);
        T3.setBounds(200, 330, 400, 50);
        T4.setBounds(200, 370, 400, 50);
        Btcontinuar.setBounds(350, 480, 100, 50);
        Btconfigurar.setBounds(0, 535, 30, 30);
        //ebento de los botones

        Btcontinuar.addActionListener(this::BtcontinuarActionPerformed);
        Btconfigurar.addActionListener(this::BtconfigurarActionPerformed);
        
    }

    private void BtcontinuarActionPerformed(ActionEvent e) {
        

        String pb1, pb2, pb3, pb4;
        pb1 = p1.getR1().substring(0, 1);
        pb2 = p1.getR2().substring(0, 1);
        pb3 = p1.getR3().substring(0, 1);
        pb4 = p1.getR4().substring(0, 1);
        if (R1.getA() < 25) {
            R1.setA(R1.getA() + 1);
            System.out.println(R1.getA());
            if (pb1.equals("*") && T1.isSelected()) {
                actdinero();
                cambiarpregunta();
            } else if (pb2.equals("*") && T2.isSelected()) {
                actdinero();
                cambiarpregunta();
            } else if (pb3.equals("*") && T3.isSelected()) {
                actdinero();
                cambiarpregunta();
            } else if (pb4.equals("*") && T4.isSelected()) {
                actdinero();
                cambiarpregunta();
            } else {
                J1.setVida(J1.getVida() - 1);
                if (J1.getVida() == 0) {
                    this.setVisible(false);
                    VPreguntas open = new VPreguntas();
                    open.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Haz perdido, vuelve a intentarlo");
                }
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "Haz ganado un total de $ "+J1.getDinero()+"  gracias por jugar!!!!");
            this.setVisible(false);
            Inicio open = new Inicio();
            open.setVisible(true);
        }
    }

    public void cambiarpregunta() {
        int tam ;
        tam  = (int) (Math.random()*(D1.size()-1)) + 1;
        switch (R1.getA()) {
            case 1:
                p1.setPR1(D2.get(tam -1).getPR1());
                p1.setR1(D2.get(tam -1).getR1());
                p1.setR2(D2.get(tam -1).getR2());
                p1.setR3(D2.get(tam -1).getR3());
                p1.setR4(D2.get(tam -1).getR4());
            break;
            case 2:
                p1.setPR1(D3.get(tam -1).getPR1());
                p1.setR1(D3.get(tam -1).getR1());
                p1.setR2(D3.get(tam -1).getR2());
                p1.setR3(D3.get(tam -1).getR3());
                p1.setR4(D3.get(tam -1).getR4());
            break;
            case 3:
                p1.setPR1(D4.get(tam -1).getPR1());
                p1.setR1(D4.get(tam -1).getR1());
                p1.setR2(D4.get(tam -1).getR2());
                p1.setR3(D4.get(tam -1).getR3());
                p1.setR4(D4.get(tam -1).getR4());
            break;
            case 4:
                p1.setPR1(D5.get(tam -1).getPR1());
                p1.setR1(D5.get(tam -1).getR1());
                p1.setR2(D5.get(tam -1).getR2());
                p1.setR3(D5.get(tam -1).getR3());
                p1.setR4(D5.get(tam -1).getR4());
                J1.setDinero(J1.getDinero()+50000);
                JOptionPane.showMessageDialog(null, "Haz ganado 50.000 por finalizar la ronda, sigue asi!!!");
            break;
            case 5:
                p1.setPR1(D1.get(tam -1).getPR1());
                p1.setR1(D1.get(tam -1).getR1());
                p1.setR2(D1.get(tam -1).getR2());
                p1.setR3(D1.get(tam -1).getR3());
                p1.setR4(D1.get(tam -1).getR4());
            break;
            case 6:
                p1.setPR1(D2.get(tam -1).getPR1());
                p1.setR1(D2.get(tam -1).getR1());
                p1.setR2(D2.get(tam -1).getR2());
                p1.setR3(D2.get(tam -1).getR3());
                p1.setR4(D2.get(tam -1).getR4());
            break;
            case 7:
                p1.setPR1(D3.get(tam -1).getPR1());
                p1.setR1(D3.get(tam -1).getR1());
                p1.setR2(D3.get(tam -1).getR2());
                p1.setR3(D3.get(tam -1).getR3());
                p1.setR4(D3.get(tam -1).getR4());
            break;
            case 8:
                p1.setPR1(D4.get(tam -1).getPR1());
                p1.setR1(D4.get(tam -1).getR1());
                p1.setR2(D4.get(tam -1).getR2());
                p1.setR3(D4.get(tam -1).getR3());
                p1.setR4(D4.get(tam -1).getR4());
            break;
            case 9:
                p1.setPR1(D5.get(tam -1).getPR1());
                p1.setR1(D5.get(tam -1).getR1());
                p1.setR2(D5.get(tam -1).getR2());
                p1.setR3(D5.get(tam -1).getR3());
                p1.setR4(D5.get(tam -1).getR4());
                J1.setDinero(J1.getDinero()+50000);
                JOptionPane.showMessageDialog(null, "Haz ganado 50.000 por finalizar la ronda, sigue asi!!!");
            break;
            case 10:
                p1.setPR1(D1.get(tam -1).getPR1());
                p1.setR1(D1.get(tam -1).getR1());
                p1.setR2(D1.get(tam -1).getR2());
                p1.setR3(D1.get(tam -1).getR3());
                p1.setR4(D1.get(tam -1).getR4());
            break;
            case 11:
                p1.setPR1(D2.get(tam -1).getPR1());
                p1.setR1(D2.get(tam -1).getR1());
                p1.setR2(D2.get(tam -1).getR2());
                p1.setR3(D2.get(tam -1).getR3());
                p1.setR4(D2.get(tam -1).getR4());
            break;
            case 12:
                p1.setPR1(D3.get(tam -1).getPR1());
                p1.setR1(D3.get(tam -1).getR1());
                p1.setR2(D3.get(tam -1).getR2());
                p1.setR3(D3.get(tam -1).getR3());
                p1.setR4(D3.get(tam -1).getR4());
            break;
            case 13:
                p1.setPR1(D4.get(tam -1).getPR1());
                p1.setR1(D4.get(tam -1).getR1());
                p1.setR2(D4.get(tam -1).getR2());
                p1.setR3(D4.get(tam -1).getR3());
                p1.setR4(D4.get(tam -1).getR4());
            break;
            case 14:
                p1.setPR1(D5.get(tam -1).getPR1());
                p1.setR1(D5.get(tam -1).getR1());
                p1.setR2(D5.get(tam -1).getR2());
                p1.setR3(D5.get(tam -1).getR3());
                p1.setR4(D5.get(tam -1).getR4());
                J1.setDinero(J1.getDinero()+50000);
                JOptionPane.showMessageDialog(null, "Haz ganado 50.000 por finalizar la ronda, sigue asi!!!");
            break;    
            case 15:
                p1.setPR1(D1.get(tam -1).getPR1());
                p1.setR1(D1.get(tam -1).getR1());
                p1.setR2(D1.get(tam -1).getR2());
                p1.setR3(D1.get(tam -1).getR3());
                p1.setR4(D1.get(tam -1).getR4());
            break;
            case 16:
                p1.setPR1(D2.get(tam -1).getPR1());
                p1.setR1(D2.get(tam -1).getR1());
                p1.setR2(D2.get(tam -1).getR2());
                p1.setR3(D2.get(tam -1).getR3());
                p1.setR4(D2.get(tam -1).getR4());
            break;
            case 17:
                p1.setPR1(D3.get(tam -1).getPR1());
                p1.setR1(D3.get(tam -1).getR1());
                p1.setR2(D3.get(tam -1).getR2());
                p1.setR3(D3.get(tam -1).getR3());
                p1.setR4(D3.get(tam -1).getR4());
            break;
            case 18:
                p1.setPR1(D4.get(tam -1).getPR1());
                p1.setR1(D4.get(tam -1).getR1());
                p1.setR2(D4.get(tam -1).getR2());
                p1.setR3(D4.get(tam -1).getR3());
                p1.setR4(D4.get(tam -1).getR4());
            break;
            case 19:
                p1.setPR1(D5.get(tam -1).getPR1());
                p1.setR1(D5.get(tam -1).getR1());
                p1.setR2(D5.get(tam -1).getR2());
                p1.setR3(D5.get(tam -1).getR3());
                p1.setR4(D5.get(tam -1).getR4());
                J1.setDinero(J1.getDinero()+50000);
                JOptionPane.showMessageDialog(null, "Haz ganado 50.000 por finalizar la ronda, sigue asi!!!");
            break;
            case 20:
                
                p1.setPR1(D1.get(tam -1).getPR1());
                p1.setR1(D1.get(tam -1).getR1());
                p1.setR2(D1.get(tam -1).getR2());
                p1.setR3(D1.get(tam -1).getR3());
                p1.setR4(D1.get(tam -1).getR4());
            break;
            case 21:
                p1.setPR1(D2.get(tam -1).getPR1());
                p1.setR1(D2.get(tam -1).getR1());
                p1.setR2(D2.get(tam -1).getR2());
                p1.setR3(D2.get(tam -1).getR3());
                p1.setR4(D2.get(tam -1).getR4());
            break;
            case 22:
                p1.setPR1(D3.get(tam -1).getPR1());
                p1.setR1(D3.get(tam -1).getR1());
                p1.setR2(D3.get(tam -1).getR2());
                p1.setR3(D3.get(tam -1).getR3());
                p1.setR4(D3.get(tam -1).getR4());
            break;
            case 23:
                p1.setPR1(D4.get(tam -1).getPR1());
                p1.setR1(D4.get(tam -1).getR1());
                p1.setR2(D4.get(tam -1).getR2());
                p1.setR3(D4.get(tam -1).getR3());
                p1.setR4(D4.get(tam -1).getR4());
            break;
            case 24:
                p1.setPR1(D5.get(tam -1).getPR1());
                p1.setR1(D5.get(tam -1).getR1());
                p1.setR2(D5.get(tam -1).getR2());
                p1.setR3(D5.get(tam -1).getR3());
                p1.setR4(D5.get(tam -1).getR4());
                J1.setDinero(J1.getDinero()+50000);
                
            break;    
        }
        Pregunta.setText("<html>"+p1.getPR1()+"<html>");
        
        T1.setText((p1.getR1()).replace("*", ""));
        T2.setText((p1.getR2()).replace("*", ""));
        T3.setText((p1.getR3()).replace("*", ""));
        T4.setText((p1.getR4()).replace("*", ""));
        

    }
    
    public void llenar(){
        try {
                for (int i = 1; i < 6; i++) {
                    FileReader fr = new FileReader("preguntas/Preguntas" + i + ".txt");
                    BufferedReader br = new BufferedReader(fr);
                    String d;
                    while ((d = br.readLine()) != null) {

                        StringTokenizer dato = new StringTokenizer(d, "|");
                        Preguntas unico = new Preguntas();
                        while (dato.hasMoreTokens()) {
                            unico.setPR1(dato.nextToken());
                            unico.setR1(dato.nextToken());
                            unico.setR2(dato.nextToken());
                            unico.setR3(dato.nextToken());
                            unico.setR4(dato.nextToken());
                            if (i==1) {
                                D1.add(unico);
                            } else if (i==2) {
                                D2.add(unico);
                            } else if (i==3) {
                                D3.add(unico);
                            } else if (i==4) {
                                D4.add(unico);
                            } else if (i==5) {
                                D5.add(unico);
                            }
                        }
                    }
            }
        } catch (Exception e) {
            
            System.out.println("Algo salió mal");
        }
    }
    
     private void BtconfigurarActionPerformed(ActionEvent e) {
         Inpreguntas open = new Inpreguntas();
         open.setVisible(true);
     }
     
     public void actdinero(){
        J1.setDinero(J1.getDinero()+5000);
        Dinero.setText("<html> Tienes : \n$ "+String.valueOf(J1.getDinero())+"<html>");
     }
}
