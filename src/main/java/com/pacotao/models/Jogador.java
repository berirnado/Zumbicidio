/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import com.pacotao.controllers.JogoController;
import java.util.*;

/**
 *
 * @author Bernardo Robaina
 */

public class Jogador extends Personagem {
    private int percepcao;
    private Mapa mapa;
    private JogoController jogoController;
    private List<Item> listItens;
    
    public Jogador(int saude, int x, int y, int percepcao, Mapa mapa) {
        super("J", "caminhoImagem", saude, x, y);
        this.mapa = mapa;
        this.percepcao = percepcao;
        this.listItens = new ArrayList<Item>();
    }
    
    public void setJogoController(JogoController jogoController){
        this.jogoController = jogoController;
    }

    /**
     * 
     * @param direcao
     * @return true se cosneguiu completar a ação
     */
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
    
    //Retorna uma lista com os itens do inventário do jogador
    public List<Item> getListItens(){
        return this.listItens;
    }
    
    public void coletarItem(Item item){
        this.listItens.add(item);
    }
    
    public boolean curar(){
        if(!listItens.isEmpty()){
          for(int i = 0; i < listItens.size(); i++){
            if(listItens.get(i) instanceof Medicamento){
                if(this.getSaude() == 5){
                    System.out.println("Você já está com a vida cheia!");
                    return false;
                }
                System.out.println("Curando...");
                this.setSaude(getSaude() + 1);
                listItens.remove(i);
                return true;
            }
           }
        }
        System.out.println("Não há cura no inventário");
        return false;
        //Lógica de cura do jogador
    }
    
}

