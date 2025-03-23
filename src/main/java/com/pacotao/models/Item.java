/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Item {
    private String nome;
    private ImageIcon imagem;
    
    public Item(String nome, String imagePath){
        this.nome = nome;
        this.imagem = new ImageIcon(imagePath);
        this.trataImagem();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public ImageIcon getIcone(){
        return imagem;
    }
    
    private void trataImagem(){
        Image image = imagem.getImage(); 
        
        Image tratada = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        
        this.imagem = new ImageIcon(tratada);
    }
}

