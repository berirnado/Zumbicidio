/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import com.pacotao.controllers.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Bernardo Robaina
 */
public class TelaFimDeJogo extends JPanel{
    public TelaFimDeJogo(JogoController jogoController, boolean venceu){
        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        
        JLabel label;
        label = new JLabel(venceu ? "Você venceu!" : "Você perdeu!");
        label.setFont(new Font("Arial", Font.BOLD, 32));
        add(label, gbc);
        
        gbc.gridy++;
        JButton reiniciarButton = new JButton("Reiniciar Jogo");
        reiniciarButton.addActionListener(e -> jogoController.reiniciarJogo());
        add(reiniciarButton, gbc);
        
        gbc.gridy++;
        JButton novoJogoButton = new JButton("Novo jogo");
        novoJogoButton.addActionListener(e -> jogoController.novoJogo());
        
        
    }
}
