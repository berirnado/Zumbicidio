/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zumbicidiojogo;

/**
 *
 * @author Bernardo Robaina
 */
public class ZumbiCorredor extends Zumbi{
    public ZumbiCorredor(int x, int y){
        super(2, x, y);
    }
    
    @Override
    public void mover(Personagem personagem){
        //TODO: Implementar logica de movimentação do zumbi corredor
        System.out.println("Movimentação do Zumbi Corredor");
    }
}
