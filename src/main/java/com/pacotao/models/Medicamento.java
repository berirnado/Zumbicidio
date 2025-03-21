/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class Medicamento extends Item{
    private int qtdCura;
    
    public Medicamento(String nome, int qtdCura) {
        super(nome);
        this.qtdCura = qtdCura;
    }
}
