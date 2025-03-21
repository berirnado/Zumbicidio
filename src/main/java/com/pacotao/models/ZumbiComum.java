/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class ZumbiComum extends Zumbi {
    
    public ZumbiComum(int x, int y){
        //Zumbi comum começa com 2 de hp
        super(2, x, y);
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Implementar logica de movimentação do zumbi comum
        System.out.println("Zumbi Gigante não se move");
    }
}
