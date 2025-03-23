/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import javax.swing.JOptionPane;

/**
 *
 * @author Bernardo Robaina
 */
public class Arma extends Item{
    private int dano;
    private int municao;
    
    public Arma(String nome, int dano, int municao){
        super(nome, getImagePath(nome));
        this.dano = dano;
        this.municao = municao;
        
    }
    
    private static String getImagePath(String nome){
        String imagePath = "src/main/java/com/pacotao/imagens/";
        switch(nome){
            case "Revolver" -> imagePath += "arma.png";
            case "Taco" -> imagePath += "taco_baseball.png";
            default -> System.out.println("Ocorreu um erro, arma " + nome + " não encontrada");
        }
        return imagePath;
    }
    
    public int getMunicao(){
        return this.municao;
    }
    
    public void setMunicao(int municao){
        this.municao = municao;
    }
}
