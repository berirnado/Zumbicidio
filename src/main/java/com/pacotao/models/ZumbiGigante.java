/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class ZumbiGigante extends Zumbi{
    public ZumbiGigante(int x, int y){
        super(3, x, y);
        this.setImagem(gerarImagem());
    }
    
    @Override
    public void mover(Personagem personagem, Celula[][] matriz){
        //ZUMBI GIGANTE NÃO SE MOVE
    }
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/zumbi_gigante.png";
        return stringRetorno;
    }
}
