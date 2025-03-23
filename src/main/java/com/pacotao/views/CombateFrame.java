/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import com.pacotao.controllers.*;
import java.awt.*;

import javax.swing.*;
/**
 *
 * @author Bernardo Robaina
 */
public class CombateFrame extends JFrame{
    private CombateController combateController;
    private JLabel vidaJogadorLabel;
    private JLabel vidaZumbiLabel;
    private JLabel imagemJogadorLabel;
    private JLabel imagemZumbiLabel;
    
    private final int X_SIZE = 250;
    private final int Y_SIZE = 250;
    
    private final String coracaoVermelho = "❤️";
    private final String coracaoPartido = "";
    
    public CombateFrame(CombateController combateController){
        this.combateController = combateController;
        setTitle("Combate");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Painel superior com barras de vida
        JPanel statusPanel = new JPanel(new GridLayout(1, 2));
        
        JPanel jogadorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        vidaJogadorLabel = new JLabel();
        jogadorPanel.add(vidaJogadorLabel);
        
        JPanel zumbiPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        vidaZumbiLabel = new JLabel();
        zumbiPanel.add(vidaZumbiLabel);
        
        atualizarBarrasDeVida();
        statusPanel.add(jogadorPanel);
        statusPanel.add(zumbiPanel);
        add(statusPanel, BorderLayout.NORTH);
        
    }
    
    public String preencheHealthBar(int vida){
        String vidaRetorno = "";
        for(int i = 0; i < 5; i++){
            if(i > vida){
                vidaRetorno += coracaoPartido;
            }else{
                vidaRetorno += coracaoVermelho;
            }
        }
        return vidaRetorno;
    }
    
    public void atualizarBarrasDeVida() {
        String vidaJogador = preencheHealthBar(combateController.getVidaJogador());
        String vidaZumbi = preencheHealthBar(combateController.getVidaZumbi());
        
        vidaJogadorLabel.setText(vidaJogador);
        vidaZumbiLabel.setText(vidaZumbi);
    }
    
    // Carregar imagens dos personagens
    public void carregarImagens() {
        try {
            
            ImageIcon playerIcon = this.combateController.getImagem(this.combateController.getJogador());
            ImageIcon zombieIcon = this.combateController.getImagem(this.combateController.getZumbi());;

            imagemJogadorLabel.setIcon(new ImageIcon(playerIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            imagemJogadorLabel.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagens: " + e.getMessage());
        }
    }
}
