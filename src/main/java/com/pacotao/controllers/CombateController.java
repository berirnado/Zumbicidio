/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.controllers;

import com.pacotao.models.*;
import com.pacotao.views.*;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author Bernardo Robaina
 */
public class CombateController {
    private JogoController jogoController;
    private Jogador jogador;
    private Zumbi zumbi;
    private CombateFrame combateView;
    
    public CombateController(JogoController jogoController, Jogador jogador, Zumbi zumbi){
        this.jogoController = jogoController;
        this.jogador = jogador;
        this.zumbi = zumbi;
        
        iniciaCombate();
        
    }
    
    public void iniciaCombate(){
        CombateFrame combateView = new CombateFrame(this);
        combateView.setVisible(true);
        this.combateView = combateView;
    }
    
    public void atacarZumbi(boolean usaArma){
        if(usaArma){
            Arma arma = this.jogador.getRevolver();
            if(arma != null){
                arma.setMunicao(arma.getMunicao() - 1);
                if(this.zumbi instanceof ZumbiCorredor){
                    combateView.atualizarBarrasDeVida();
                }
                this.zumbi.setSaude(this.getVidaZumbi() - 2);
                combateView.atualizarBarrasDeVida();
            }
        }else {
            if(this.jogador.getTacoBaseball() != null){
                this.zumbi.setSaude(this.getVidaZumbi() - 2);
                combateView.mostrarResultadoDado(6, "Acerto crítico! 2 de dano no zumbi");
            }else{
                int resultado = rolarDado();
                if(resultado == this.jogador.getPercepcao()){
                    this.zumbi.setSaude(this.getVidaZumbi() - 2);
                    combateView.mostrarResultadoDado(resultado, "Acerto crítico! 2 de dano no zumbi");
                    combateView.atualizarBarrasDeVida();
                }else{
                    this.zumbi.setSaude(this.getVidaZumbi() - 1);
                    combateView.mostrarResultadoDado(resultado, "Acerto! 1 de dano no zumbi");
                    combateView.atualizarBarrasDeVida();
                }
        }
        if(this.zumbi.getSaude() > 0){
            rodadaZumbi();
        }else{
            finalizarCombate();
        }
    }
        
    }
    public void finalizarCombate(){
        if(this.jogador.getSaude() <= 0){
            combateView.mostrarResultado("Você perdeu!", "Derrota", true);
        }else if (this.zumbi.getSaude() <= 0) {
            combateView.mostrarResultado("Você venceu!", "Vitória", true);
            this.zumbi.removeZumbi();
            
            
            System.out.println("Finalizar");
            //Retira imagem de zumbi da matriz
            int zumbiX = zumbi.getPosicao()[1];
            int zumbiY = zumbi.getPosicao()[0];
            Celula[][] matrizMapa = this.jogoController.getMatrizMapa();
            matrizMapa[zumbiX][zumbiY].setObjeto(new Vazio(zumbiX, zumbiY));
            this.jogoController.getTabuleiro().repaint();
        }
    }
    
    public void rodadaZumbi(){
        //ROLAR DADO
        combateView.mostrarResultado("Vez do zumbi!", "Zumbi", false);
        int resultado = rolarDado();
        if(resultado > this.jogador.getPercepcao()){
            this.jogador.setSaude(this.jogador.getSaude() - 1);
            combateView.mostrarResultadoDado(resultado, "Zumbi atacou! -1 hp");
            combateView.atualizarBarrasDeVida();
            if(this.jogador.getSaude() <= 0){
                finalizarCombate();
            }
        }else{
            combateView.mostrarResultadoDado(resultado, "Esquiva! Não tomou dano do zumbi");
        }
    }
    
    public int rolarDado(){
        Random rand = new Random();
        int resultado = rand.nextInt(6) + 1;
        
        return resultado;
    }
    
    public void cura(){
        this.jogador.curar();
        rodadaZumbi();
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
