/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */public class ZumbiComum extends Zumbi {

    private static final String CAMINHO_IMAGEM = "src/main/java/com/pacotao/imagens/zumbi_comum.png";

    public ZumbiComum(int x, int y) {
        super(2, CAMINHO_IMAGEM, x, y); // Define a imagem específica do Zumbi Comum
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Implementar logica de movimentação do zumbi comum
        System.out.println("Zumbi Gigante não se move");
    }
}
