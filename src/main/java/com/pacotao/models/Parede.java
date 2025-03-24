/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class Parede extends ObjetoMapa{
    public Parede(int x, int y){
        super("P", x, y);
        this.setImagem(this.gerarImagem());
    }
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/parede_tijolo.png";
        return stringRetorno;
    }
}
