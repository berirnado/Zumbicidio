/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import javax.swing.*;
import java.awt.*;
import com.pacotao.models.*;
import com.pacotao.controllers.JogoController;

/**
 *
 * @author Bernardo Robaina
 */

public class GamePanel extends JPanel {
    private TabuleiroPanel tabuleiroPanel;
    private JPanel vidaPanel; // Painel para exibir a vida do jogador
    private JPanel itensPanel; // Painel para exibir os itens do jogador
    private JPanel controlePanel; // Painel de controles (D-pad)
    private Jogo jogo;

    public GamePanel(Jogo jogo, JogoController jogoController) {
        this.jogo = jogo;
        setLayout(new BorderLayout()); // Usa BorderLayout para organizar os painéis principais

        Celula[][] matrizCelulas = jogo.getMapa().getMatriz();
        // Cria o TabuleiroPanel
        tabuleiroPanel = new TabuleiroPanel(jogo);
        add(tabuleiroPanel, BorderLayout.CENTER); // Adiciona o tabuleiro ao centro

        // Cria o painel de vida do jogador (embaixo do tabuleiro)
        vidaPanel = new JPanel();
        vidaPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centraliza o conteúdo
        vidaPanel.setBorder(BorderFactory.createTitledBorder("Vida do Jogador"));
        vidaPanel.add(new JLabel("Vida: 5")); // Exemplo de informação
        add(vidaPanel, BorderLayout.SOUTH); // Adiciona o painel de vida ao sul

        // Cria um painel para organizar itens e controles no lado direito
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        // Cria o painel de itens do jogador (grid 2x3)
        itensPanel = new InventarioPanel(jogoController);
        rightPanel.add(itensPanel, BorderLayout.NORTH); // Adiciona o painel de itens ao norte do rightPanel
        
        // Cria o painel de controles (D-pad)
        controlePanel = new JPanel();
        controlePanel.setLayout(new GridBagLayout()); // Usa GridBagLayout para posicionar os botões
        controlePanel.setBorder(BorderFactory.createTitledBorder("Controles"));

        // Configuração do GridBagConstraints para posicionar os botões
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os botões

        // Botão Cima
        JButton moverCima = new JButton("↑");
        gbc.gridx = 1;
        gbc.gridy = 0;
        controlePanel.add(moverCima, gbc);
        moverCima.addActionListener(e -> jogoController.gerenciaMovimentoJogador('C'));

        // Botão Esquerda
        JButton moverEsquerda = new JButton("←");
        gbc.gridx = 0;
        gbc.gridy = 1;
        controlePanel.add(moverEsquerda, gbc);
        moverEsquerda.addActionListener(e -> jogoController.gerenciaMovimentoJogador('E'));

        // Botão Baixo
        JButton moverBaixo = new JButton("↓");
        gbc.gridx = 1;
        gbc.gridy = 2;
        controlePanel.add(moverBaixo, gbc);
        moverBaixo.addActionListener(e -> jogoController.gerenciaMovimentoJogador('B'));

        // Botão Direita
        JButton moverDireita = new JButton("→");
        gbc.gridx = 2;
        gbc.gridy = 1;
        controlePanel.add(moverDireita, gbc);
        moverDireita.addActionListener(e -> jogoController.gerenciaMovimentoJogador('D'));
        
        JButton botaoCurar = new JButton("Curar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        botaoCurar.addActionListener(e -> jogoController.curarJogador());
        controlePanel.add(botaoCurar, gbc);
        
        JButton botaoSair = new JButton("Sair");
        gbc.gridx = 1;
        gbc.gridy++;
        //botaoSair.addActionListener(e -> jogoController.);
        controlePanel.add(botaoSair, gbc);

        rightPanel.add(controlePanel, BorderLayout.CENTER); // Adiciona o painel de controles ao centro do rightPanel
        add(rightPanel, BorderLayout.EAST); // Adiciona o rightPanel à direita do GamePanel
        
        jogoController.setTabuleiro(tabuleiroPanel);
    }
}