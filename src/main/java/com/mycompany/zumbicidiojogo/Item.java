/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zumbicidiojogo;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Item {
    private String nome;
    
    public Item(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
}

