/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Bernardo Robaina
 * 
 * ------------- MainFrame que organiza a troca de telas do jogo
 */

public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    public MainFrame(){
        super("Zumbicidio");
        setSize(1040, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuração do CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adiciona as telas ao CardLayout
        MenuPanel painelMenu = new MenuPanel(this);
        mainPanel.add(painelMenu, "Menu");
        mainPanel.add(new DificuldadePanel(this, painelMenu), "Dificuldade");
        //mainPanel.add(new GamePanel(this), "Game");

        add(mainPanel);
        this.mostraTela("Dificuldade");
        setVisible(true);
    }
    
    // Método para navegar entre telas
    public void mostraTela(String nomeTela) {
        cardLayout.show(mainPanel, nomeTela);
    }
}
