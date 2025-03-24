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
    private Mapa mapa;
    private boolean turnoJogador;
    public boolean ehDebug;
    protected Random random;
    private final ZumbiComum zumbi;
    private String mapaString;

    public Jogo(int percepcao, boolean ehDebug) {
        this.turnoJogador = true;
        this.ehDebug = ehDebug;
        this.percepcao = percepcao;
        this.random = new Random();
        this.zumbi = new ZumbiComum(999, 999);
    }

    public void iniciar() {
        //Instanciar mapa
        this.mapaString = "src/main/java/com/pacotao/Mapas/mapa_" + String.valueOf(this.random.nextInt(5) + 1) + ".txt";
        this.mapa = new Mapa(mapaString, this.percepcao, this.ehDebug); 
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
        return zumbi.listarZumbis();
    }
    
    public void resetarEstadoInicial() {
        // Reinicia jogador
        jogador.getPosicao()[0] = 0;
        jogador.setSaude(5);
        new Mapa(this.mapaString, this.percepcao, this.ehDebug);
        
        
    }
}

