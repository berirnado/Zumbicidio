/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class Arma extends Item{
    private int dano;
    private int municao;
    
    public Arma(String nome, int dano, int municao){
        super(nome);
        this.dano = dano;
        this.municao = municao;
    }
}
