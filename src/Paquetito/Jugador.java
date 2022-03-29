/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquetito;

/**
 *
 * @author Cristian Camilo Pelaez Bedoya (Lucy)
 */
public class Jugador {
     private int Dinero;
     private int vida;

    public Jugador() {
        vida=1;
    }

    public Jugador(int Dinero) {
        vida=1;
        this.Dinero = Dinero;
    }

    public int getDinero() {
        return Dinero;
    }

    public void setDinero(int Dinero) {
        this.Dinero = Dinero;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
