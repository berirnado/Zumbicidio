/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class Jogador extends Personagem {
    private int percepcao;
    private Mapa mapa;
    
    public Jogador(int saude, int x, int y, int percepcao, Mapa mapa) {
        super("J", "caminhoImagem", saude, x, y);
        this.mapa = mapa;
        this.percepcao = percepcao;
    }

    public boolean mover(char direcao) {
        boolean moverOk = false;
        // Lógica de movimento do jogador (pode ser controlada pelo usuário)
        switch (direcao) {
            case 'C' -> {
                if(mapa.ehPosicaoValida(x, y - 1)){
                    y--;
                    moverOk = true;
                }
            }
            case 'B' -> {
                if(mapa.ehPosicaoValida(x, y + 1)){
                    y++;
                    moverOk = true;
                }
            }
            case 'E' -> {
                if(mapa.ehPosicaoValida(x - 1, y)){
                    x--;
                    moverOk = true;
                }
            }
            case 'D' -> {
                if(mapa.ehPosicaoValida(x + 1, y)){
                    x++;
                    moverOk = true;
                }
            }
            default -> {
                System.out.println("Direção inválida!");
            }
        }
        return moverOk;
    }

    public void atacar() {
        // Lógica de ataque do jogador
    }
    
}

