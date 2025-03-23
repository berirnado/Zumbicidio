/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.pacotao.controllers.*;
/**
 *
 * @author Bernardo Robaina
 * 
 * ------------- TELA DE MENU DO JOGO
 */


public class MenuPanel extends JPanel {
    private static int percepcao;
    private JogoController jogoController;
    
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
        jogoController = new JogoController();
        //Inicia jogo com debug = false
        botaoJogar.addActionListener(e -> jogoController.iniciarJogo(frame, percepcao, false));
        
        //Botão Debug
        JButton botaoDebug = new JButton("Debug");
        gbc.gridy++;
        add(botaoDebug, gbc);
        //Inicia jogo com debug = true
        botaoDebug.addActionListener(e -> jogoController.iniciarJogo(frame, percepcao, true));
        
        //Botão Sair
        JButton botaoSair = new JButton("Sair");
        gbc.gridy++;
        add(botaoSair, gbc);
        botaoSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", 
                                                         "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0); // Fecha o programa
            }
        });
        
        setVisible(true);
        
    }
    
    protected void setPercepcao(int percepcao){
        this.percepcao = percepcao;
    }
}
