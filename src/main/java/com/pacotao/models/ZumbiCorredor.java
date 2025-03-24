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
    public void mover(Personagem personagem, Celula[][] matriz){
        //TODO: Implementar logica de movimentação do zumbi corredor
        System.out.println("Movimentação do Zumbi Corredor");
        System.out.println("Movimentacao zumbi comum");
        if(personagem instanceof Jogador jogador){
            // Calcular a direção do movimento (vetor direção)
            int dx = jogador.getPosicao()[0] - x;
            int dy = jogador.getPosicao()[1] - y;

            // Normalizar o vetor para mover o zumbi em direção ao personagem (mover 1 unidade em cada direção)
            double distancia = Math.sqrt(dx * dx + dy * dy);
            double normalizacao = distancia == 0 ? 1 : distancia;

            // Calcular o novo movimento, levando em conta a velocidade do zumbi
            if(dx > dy){
                int xAnt = x;
                x += (int)(4 * dx / normalizacao);
                if(matriz[y][x].getObjeto() instanceof Vazio){
                    //Retira imagem de zumbi da matriz
                    matriz[y][xAnt].setObjeto(new Vazio(xAnt, y));
                    
                    //Atualiza a posicao do zumbi na matriz
                    matriz[y][x].setObjeto(this);
                }
            }else{
                int yAnt = y;
                //Movimenta o zumbi
                y += (int)(4 * dy / normalizacao);
                if(matriz[y][x].getObjeto() instanceof Vazio){
                    //Retira imagem de zumbi da matriz
                    matriz[yAnt][x].setObjeto(new Vazio(x, yAnt));
                    
                    //Atualiza a posicao do zumbi na matriz
                    matriz[y][x].setObjeto(this);
                }else{
                    y = yAnt;
                }
            }
            
            //Atualiza a posicao do zumbi na matriz
            matriz[y][x].setObjeto(this);
        }
    }
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/zumbi_corredor.png";
        return stringRetorno;
    }
}
