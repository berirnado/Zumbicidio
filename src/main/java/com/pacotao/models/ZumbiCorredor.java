/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public class ZumbiCorredor extends Zumbi{
    public ZumbiCorredor(int x, int y){
        super(2, x, y);
        this.setImagem(gerarImagem());
    }
    
    @Override
    public void mover(Personagem personagem, Celula[][] matriz) {
        System.out.println("Movimentacao zumbi comum");
        if (personagem instanceof Jogador jogador) {
        // Calcular a direção do movimento (vetor direção)
        int dx = jogador.getPosicao()[0] - x;
        int dy = jogador.getPosicao()[1] - y;

        // Normalizar o vetor direção
        double distancia = Math.sqrt(dx * dx + dy * dy);
        double normalizacao = distancia == 0 ? 1 : distancia; // Evitar divisão por zero

        // Mover o zumbi em uma célula por vez na direção do jogador
        int movimentoX = (int) Math.signum(dx) * 2;  // 2 ou -2 (direção X)
        int movimentoY = (int) Math.signum(dy) * 2;  // 2 ou -2 (direção Y)

            // Atualiza a posição na direção correta (X ou Y)
            if (Math.abs(dx) > Math.abs(dy)) {
                // Movimentar no eixo X
                if (matriz[y][x + movimentoX].getObjeto() instanceof Vazio) {
                    // Retira a imagem de zumbi da célula anterior
                    matriz[y][x].setObjeto(new Vazio(x, y));

                    // Atualiza a posição do zumbi na matriz
                    x += movimentoX;
                    matriz[y][x].setObjeto(this);
                }
            } else {
                // Movimentar no eixo Y
                if (matriz[y + movimentoY][x].getObjeto() instanceof Vazio) {
                    // Retira a imagem de zumbi da célula anterior
                    matriz[y][x].setObjeto(new Vazio(x, y));

                    // Atualiza a posição do zumbi na matriz
                    y += movimentoY;
                    matriz[y][x].setObjeto(this);
                }
            }
        }
    }
    
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/zumbi_corredor.png";
        return stringRetorno;
    }
}
