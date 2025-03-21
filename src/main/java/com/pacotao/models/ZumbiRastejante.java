/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class ZumbiRastejante extends Zumbi {
    
    public ZumbiRastejante(int x, int y){
        super(1, x, y);
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Implementar logica de movimentação do zumbi rastejante
        System.out.println("Movimentação do Zumbi Rastejante");
    }
}
