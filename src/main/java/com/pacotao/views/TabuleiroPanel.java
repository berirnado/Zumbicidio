/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import javax.swing.*;
import java.awt.*;
import com.pacotao.models.*;

/**
 *
 * @author Bernardo Robaina
 */

public class TabuleiroPanel extends JPanel{
    private Celula[][] celulas;
    private int tamanhoCelula = 65; // Tamanho de cada célula em pixels
    private Jogo jogo;
    private static boolean primeiroRender = true;

    public TabuleiroPanel(Jogo jogo) {
        this.celulas = jogo.getMapa().getMatriz();
        this.jogo = jogo;
        setPreferredSize(new Dimension(celulas[0].length * tamanhoCelula, celulas.length * tamanhoCelula));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[i].length; j++) {
                Celula celula = celulas[i][j];
                int x = j * tamanhoCelula; // Posição X da célula
                int y = i * tamanhoCelula; // Posição Y da célula

                if (celula.isRevelada()) {
                if (celula.getObjeto() != null && celula.getObjeto().getImagem() != null) {
                    ImageIcon concreto = new ImageIcon("src/main/java/com/pacotao/imagens/concreto1.png");
                    g.drawImage(concreto.getImage(), x, y, tamanhoCelula, tamanhoCelula, this);
                    Image imagem = celula.getObjeto().getImagem().getImage();
                    g.drawImage(imagem, x, y, tamanhoCelula, tamanhoCelula, this);
                } else {
                    Color cor = getCorPorSimbolo(celula.getObjeto().getSimbolo());
                    g.setColor(cor);
                    g.fillRect(x, y, tamanhoCelula, tamanhoCelula);
                }
            } else {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, tamanhoCelula, tamanhoCelula);
            }

                // Desenha bordas para visualização (opcional)
                g.setColor(Color.BLACK);
                g.drawRect(x, y, tamanhoCelula, tamanhoCelula);
                
            }
        }
        if(!primeiroRender){
            // Desenha o jogador
            int jogadorX = jogo.getJogador().getPosicao()[0] * tamanhoCelula;
            int jogadorY = jogo.getJogador().getPosicao()[1] * tamanhoCelula;
            Image imagem = jogo.getJogador().getImagem().getImage();
            g.drawImage(imagem, jogadorX, jogadorY, tamanhoCelula, tamanhoCelula, this);
        }else{
            primeiroRender = false;
        }
    }
        
    private Color getCorPorSimbolo(String simbolo) {
        switch (simbolo) {
            case "Z": // Zumbi
                return Color.GREEN;
            case "B": // Baú
                return Color.YELLOW; // Exemplo: amarelo para baú
            case "P": // Parede
                return Color.BLACK;
            case "V": // Vazio
                return Color.GRAY;
            default:
                return Color.WHITE; // Cor padrão para símbolos desconhecidos
        }
    }
}
