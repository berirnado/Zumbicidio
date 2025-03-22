/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Bernardo Robaina
 * 
 * ------------- TELA DE MENU DO JOGO
 */


public class MenuPanel extends JPanel {
    public MenuPanel(MainFrame frame) {
        // Painel principal com GridBagLayout para centralizar
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        
        //Título
        JLabel label = new JLabel("Zumbicídio");
        label.setFont(new Font("Serif", Font.BOLD, 50));
        add(label, gbc);

        //Botão Jogar
        JButton botaoJogar = new JButton("Jogar");
        gbc.gridy++;
        add(botaoJogar, gbc);
        botaoJogar.addActionListener(e -> frame.mostraTela("Game"));
        
        //Botão Debug
        JButton botaoDebug = new JButton("Debug");
        gbc.gridy++;
        add(botaoDebug, gbc);
        
        //Botão Sair
        JButton botaoSair = new JButton("Sair");
        gbc.gridy++;
        add(botaoSair, gbc);
        
        setVisible(true);
        
    }
}
