/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class ObjetoMapa {
    private String simbolo; // Símbolo que representa o objeto no mapa (ex: "Z" para zumbi)
    private ImageIcon imagem; // Imagem que representa o objeto na tela
    protected int x, y; // Posição do objeto no mapa

    public ObjetoMapa(String simbolo, int x, int y) {
        this.simbolo = simbolo;
        this.x = x;
        this.y = y;
    }
    public ObjetoMapa(String simbolo, String caminhoImagem, int x, int y) {
        this.simbolo = simbolo;
        this.x = x;
        this.y = y;
        this.imagem = new ImageIcon(caminhoImagem); // Carrega a imagem a partir do caminho
    }

    public String getSimbolo() {
        return simbolo;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(String caminhoImagem) {
        this.imagem = new ImageIcon(caminhoImagem);
    }
    
    public int[] getPosicao(){
        return new int[] {this.x, this.y};
    }
    
     private void trataImagem(){
        Image image = imagem.getImage(); 
        
        Image tratada = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        
        this.imagem = new ImageIcon(tratada);
    }
     
     /**
      * 
      * @param x SIZE_X
      * @param y SIZE_Y
      * @return Icone da classe tratado para os parametros de tamanho.
      */
     private ImageIcon getTrataImagem(int x, int y){
        Image image = imagem.getImage(); 
        
        Image tratada = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH);
        
        return new ImageIcon(tratada);
    }
     
    public abstract String gerarImagem();
}
