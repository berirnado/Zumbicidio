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

    public TabuleiroPanel(Celula[][] celulas) {
        this.celulas = celulas;
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

                //if (celula.isRevelada()) {
                    // Desenha a imagem do objeto na célula
                    //ImageIcon imagem = celula.getObjeto().getImagem();
                    //imagem.paintIcon(this, g, x, y);
                    Color cor = getCorPorSimbolo(celula.getObjeto().getSimbolo());
                    g.setColor(cor);
                    g.fillRect(x, y, tamanhoCelula, tamanhoCelula); // Pinta o quadrado
                //} else {
                    // Desenha uma imagem padrão para células não reveladas
                    //ImageIcon imagemOculta = new ImageIcon(getClass().getClassLoader().getResource("imagens/oculto.png"));
                    //imagemOculta.paintIcon(this, g, x, y);
                    
                //}

                // Desenha bordas para visualização (opcional)
                g.setColor(Color.BLACK);
                g.drawRect(x, y, tamanhoCelula, tamanhoCelula);
            }
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
