/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.controllers;

import com.pacotao.models.*;
import com.pacotao.views.*;

/**
 *
 * @author Bernardo Robaina
 */

public class JogoController {
    private Jogo jogo;
    private TabuleiroPanel tabuleiroPanel;
    
    public void iniciarJogo(MainFrame frame, int percepcao){
        System.out.println("Entrou iniciarJogo()");
        this.jogo = new Jogo(percepcao);
        jogo.iniciar();
        jogo.setJogador(jogo.getMapa().getJogador());
        frame.criaGamePanel(jogo, this);
    }
    
    public void gerenciaMovimentoJogador(char direcao){
        if (this.jogo.getJogador().mover(direcao)){
            System.out.println("Movimento sucedido!");
            jogo.getMapa().revelaCampoVisao(this.jogo.getJogador());
            tabuleiroPanel.repaint();
        }
    }
    
    public void setTabuleiro(TabuleiroPanel tabuleiroPanel) {
        this.tabuleiroPanel = tabuleiroPanel;
    }
    
    public boolean curarJogador(){
        return true;
    }
}
