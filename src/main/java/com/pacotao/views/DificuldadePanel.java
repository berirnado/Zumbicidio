/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bernardo Robaina
 */
public class DificuldadePanel extends JPanel {
    public DificuldadePanel(MainFrame frame, MenuPanel menu){
        setLayout(new GridBagLayout());
        setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        
        //Botão FÁCIL
        JButton botaoFacil = new JButton("Fácil");
        gbc.gridy++;
        add(botaoFacil, gbc);
        botaoFacil.addActionListener(e -> this.carregarTelaMenu(menu, 3, frame));
        
        //Botão MÉDIO
        JButton botaoMedio = new JButton("Médio");
        gbc.gridy++;
        add(botaoMedio, gbc);
        botaoMedio.addActionListener(e -> this.carregarTelaMenu(menu, 2, frame));
        
        //Botão DIFÍCIL
        JButton botaoDificil = new JButton("Difícil");
        gbc.gridy++;
        add(botaoDificil, gbc);
        botaoDificil.addActionListener(e -> this.carregarTelaMenu(menu, 1, frame));
    }
    
    private void carregarTelaMenu(MenuPanel menu, int percepcao, MainFrame frame){
        menu.setPercepcao(percepcao);
        frame.mostraTela("Menu");
    }
}

// Classe interna para o painel de fundo
    class BackgroundMenuPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundMenuPanel() {
            try {
                backgroundImage = new ImageIcon("src/main/java/com/pacotao/imagens/backgroundmenu.png").getImage();
            } catch (Exception e) {
                System.err.println("Erro ao carregar a imagem de fundo: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
