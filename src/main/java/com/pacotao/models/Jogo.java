/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Bernardo Robaina
 */

public class Jogo {
    private Jogador jogador;
    private static int percepcao;
    private List<Zumbi> zumbis;
    private Mapa mapa;
    private boolean turnoJogador;
    protected Random random;

    public Jogo(int percepcao) {
        this.turnoJogador = true;
        this.percepcao = percepcao;
        this.random = new Random();
    }

    public void iniciar() {
        //Instanciar mapa
        //this.mapa = new Mapa("src/main/java/com/pacotao/Mapas/mapa_" + String.valueOf(this.random.nextInt(5) + 1) + ".txt", this.percepcao);
        this.mapa = new Mapa("src/main/java/com/pacotao/Mapas/mapa_4.txt", this.percepcao); 
    }

    public boolean moverJogador(String direcao) {
        /**
        if (!turnoJogador) {
            return false;
        }
        boolean sucesso = jogador.mover(direcao, mapa);
        if (sucesso) {
            verificarItens();
            verificarCombate();
            turnoJogador = false;
        }
        return sucesso;
        */
        return true;
    }

    public void iniciarTurnoZumbis() {
        /**
        for (Zumbi zumbi : zumbis) {
            zumbi.mover(mapa, jogador);
        }
        verificarCombate();
        turnoJogador = true;
        */
    }

    private void verificarCombate() {
        /**
        for (Zumbi zumbi : zumbis) {
            if (zumbi.getPosicao().equals(jogador.getPosicao())) {
                jogador.receberDano(zumbi.getDano());
            }
        }
        zumbis.removeIf(z -> z.getVida() <= 0);
        */
    }

    private void verificarItens() {
        /**
        if (mapa.temItem(jogador.getPosicao())) {
            jogador.coletarItem(mapa.pegarItem(jogador.getPosicao()));
        }
        */
    }

    public boolean jogadorVenceu() {
        /**
        return mapa.objetivoConcluido(jogador.getPosicao());
        */
        return true;
    }

    public boolean jogadorDerrotado() {
        return jogador.getSaude() <= 0;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Jogador getJogador() {
        return jogador;
    }
    
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<Zumbi> getZumbis() {
        return zumbis;
    }
}

