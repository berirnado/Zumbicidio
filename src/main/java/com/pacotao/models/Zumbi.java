/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.util.*;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Zumbi extends Personagem {
    public static List<Zumbi> listZumbi = new ArrayList<>();
    
    public Zumbi(int saude, int x, int y){
        super("Z", saude, x, y);
    }
    
    public abstract void mover(Personagem personagem);
    
    public List<Zumbi> listarZumbis(){
        return listZumbi;
    }
    
    public void adicionaZumbi(Zumbi zumbi){
        listZumbi.add(zumbi);
    }
}
