/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zumbicidiojogo;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Personagem {
    protected int saude; // HP do personagem
    protected int x, y;  // Posições do personagem no mapa

    public Personagem(int saude, int x, int y) {
        this.saude = saude;
        this.x = x;
        this.y = y;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }
    
    public int[] getPosicao(){
        return new int[] {this.x, this.y};
    }

    public abstract void mover(char direcao);
}
