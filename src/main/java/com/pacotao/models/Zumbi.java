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
    
    public Zumbi(int saude, int x, int y){
        super("Z", "caminhoImagemZumbi", saude, x, y);
    }
    
    public abstract void mover(Personagem personagem);
}
