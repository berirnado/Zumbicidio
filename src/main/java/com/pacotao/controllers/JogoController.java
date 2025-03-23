/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.controllers;

import com.pacotao.models.*;
import com.pacotao.views.*;
import java.util.*;

/**
 *
 * @author Bernardo Robaina
 */

public class JogoController {
    private Jogo jogo;
    private Jogador jogador;
    
    private TabuleiroPanel tabuleiroPanel;
    private InventarioPanel inventarioPanel;
    private boolean ehDebug;
    
    public void iniciarJogo(MainFrame frame, int percepcao, boolean ehDebug){
        System.out.println("Entrou iniciarJogo()");
        
        this.jogo = new Jogo(percepcao, ehDebug);
        jogo.iniciar();
        
        jogo.setJogador(jogo.getMapa().getJogador());
        this.jogador = jogo.getJogador();
        this.jogador.setJogoController(this);
        
        this.ehDebug = ehDebug;
        
        frame.criaGamePanel(jogo, this);
    }
    
    public void gerenciaMovimentoJogador(char direcao){
        if (jogador.mover(direcao)){
            if(!ehDebug){
                jogo.getMapa().revelaCampoVisao(this.jogo.getJogador());   
            }
            tabuleiroPanel.repaint();
        }
    }
    
    public void setInventarioPanel(InventarioPanel inventarioPanel) {
        this.inventarioPanel = inventarioPanel;
    }
    
    public void setTabuleiro(TabuleiroPanel tabuleiroPanel) {
        this.tabuleiroPanel = tabuleiroPanel;
    }
    
    public boolean curarJogador(){
        System.out.println("Vida atual: " + jogador.getSaude());
        jogador.curar();
        System.out.println("Vida atual: " + jogador.getSaude());
        atualizaInventario();
        return true;
    }
    
    public void atualizaInventario(){
        if (inventarioPanel != null) {
            inventarioPanel.atualizar(jogador.getListItens()); // Chama o método de atualização do painel
        }
    }
    
    public List<Item> getInventario(){
        return jogador.getListItens();
    }
}
