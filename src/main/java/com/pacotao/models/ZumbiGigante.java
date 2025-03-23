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
    
    private static final String CAMINHO_IMAGEM = "src/main/java/com/pacotao/imagens/zumbi_gigante.png";
    
    public ZumbiGigante(int x, int y){
        super(3,CAMINHO_IMAGEM, x, y);
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Zumbi Gigante não se move
        System.out.println("Zumbi Gigante não se move");
    }
}
