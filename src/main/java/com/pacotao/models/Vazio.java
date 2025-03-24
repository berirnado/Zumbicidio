/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.util.Random;

/**
 *
 * @author Bernardo Robaina
 */
public class Vazio extends ObjetoMapa {
    protected Random random;
    
    public Vazio(int x, int y){
        super("V", x, y);
        this.random = new Random();
        this.setImagem(this.gerarImagem());
    }
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/concreto" + String.valueOf(random.nextInt(4) + 1) + ".png";
        return stringRetorno;
    }
}
