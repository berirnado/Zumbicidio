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
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Zumbi Gigante não se move
        System.out.println("Zumbi Gigante não se move");
    }
}
