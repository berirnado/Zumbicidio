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
 */
public class MainFrame extends JFrame{
    public MainFrame(){
        super("Zumbicidio");
        setSize(1040, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());
        
        
        Container tela = getContentPane();
        tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Zumbicídio");
        label.setFont(new Font("Seriff", Font.BOLD, 50));
        label.setLocation(this.getWidth() / 2, this.getHeight() / 2);
        
        JButton botaoJogar = new JButton("Jogar");
        botaoJogar.setSize(20, 70);
        
        JPanel botoes = new JPanel();
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.Y_AXIS));
        
        botoes.add(label);
        botoes.add(botaoJogar);
        
        tela.add(label);
        tela.add(botoes);
        setVisible(true);
    }
}
