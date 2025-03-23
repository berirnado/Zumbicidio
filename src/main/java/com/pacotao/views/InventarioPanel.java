/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import com.pacotao.controllers.JogoController;
import com.pacotao.models.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Bernardo Robaina
 */
public class InventarioPanel extends JPanel{
    private List<Item> itens = new ArrayList<>();
    
    public InventarioPanel(JogoController jogoController){
        // Cria o painel de itens do jogador (grid 1x3)
        setLayout(new GridLayout(1, 3, 5, 5)); // Grid de 2 linhas e 3 colunas com espaçamento de 5 pixels
        setBorder(BorderFactory.createTitledBorder("Inventário"));

        // Adiciona 3 espaços quadrados ao grid de itens
        for (int i = 0; i < 3; i++) {
            JLabel itemLabel = new JLabel(); // Cria um JLabel para cada espaço
            itemLabel.setPreferredSize(new Dimension(50, 50)); // Define o tamanho quadrado (50x50 pixels)
            itemLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza o ícone
            itemLabel.setVerticalAlignment(JLabel.CENTER); // Centraliza o ícone
            itemLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Adiciona borda para visualização
            add(itemLabel);
        }
        jogoController.setInventarioPanel(this);
    }
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < getComponentCount(); i++){
            JLabel itemLabel = (JLabel) getComponent(i); // Obtém o JLabel correspondente
            itemLabel.setIcon(null); // Limpa o ícone anterior
            
            if(!itens.isEmpty()){
                if(i < itens.size()) {
                Item item = itens.get(i);
                itemLabel.setIcon(item.getIcone());
                if(item instanceof Arma arma){
                        if(arma.getNome() == "Revolver"){
                            itemLabel.setBorder(BorderFactory.createTitledBorder(String.valueOf(arma.getMunicao())));
                        }
                    }
                }
            }
        }
    }
    
    // Método para atualizar o painel
    public void atualizar(List<Item> itens) {
        this.itens = itens;
        repaint(); // Força o redesenho do painel
    }
}
