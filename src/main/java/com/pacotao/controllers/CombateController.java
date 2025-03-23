/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.controllers;

import com.pacotao.models.*;
import com.pacotao.views.*;
import javax.swing.ImageIcon;
/**
 *
 * @author Bernardo Robaina
 */
public class CombateController {
    private JogoController jogoController;
    private Jogador jogador;
    private Zumbi zumbi;
    
    public CombateController(JogoController jogoController, Jogador jogador, Zumbi zumbi){
        this.jogoController = jogoController;
        this.jogador = jogador;
        this.zumbi = zumbi;
        
        iniciaCombate();
        
    }
    
    public void iniciaCombate(){
        CombateFrame combateView = new CombateFrame(this);
        combateView.setVisible(true);
    }
    
    public int getVidaJogador(){
        return this.jogador.getSaude();
    }
    
    public int getVidaZumbi(){
        return this.zumbi.getSaude();
    }
    
    public ImageIcon getImagem(ObjetoMapa personagem){
        return personagem.getImagem();
    }
    
    public Jogador getJogador(){
        return this.jogador;
    }
    
    public Zumbi getZumbi(){
        return this.zumbi;
    }
}
