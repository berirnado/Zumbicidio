/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Zumbi extends Personagem {

    /*O método construtor foi alterado para poder definir uma imagem específica para cada zumbi*/
    
    public Zumbi(int saude, String caminhoImagem, int x, int y) {
        super("Z", caminhoImagem, saude, x, y);
    }

    public abstract void mover(Personagem personagem);
}
