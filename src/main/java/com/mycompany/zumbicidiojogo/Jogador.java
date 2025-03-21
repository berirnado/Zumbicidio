/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zumbicidiojogo;

/**
 *
 * @author Bernardo Robaina
 */
public class Jogador extends Personagem {
    private int percepcao;
    
    public Jogador(int saude, int x, int y, int percepcao) {
        super(saude, x, y);
        this.percepcao = percepcao;
    }

    @Override
    public void mover(char direcao) {
        // Lógica de movimento do jogador (pode ser controlada pelo usuário)
        switch (direcao) {
            case 'C' -> y--;
            case 'B' -> y++;
            case 'E' -> x--;
            case 'D' -> x++;
            default -> System.out.println("Direção inválida!");
        }
    }

    public void atacar() {
        // Lógica de ataque do jogador
    }
}

