/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bernardo Robaina
 */
public class Mapa {
    private Celula[][] matriz;
    private int largura;
    private int altura;
    private int percepcao;
    protected Jogador jogador;

    public Mapa(String caminhoArquivo, int percepcao) {
        this.percepcao = percepcao;
        carregarMapa(caminhoArquivo);
        this.jogador = this.encontrarJogador();
        this.revelaCampoVisao(jogador);
    }
    
    private void carregarMapa(String caminhoArquivo) {
        System.out.println("Entrou carregarMapa()");
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int linhas = 0;
            while ((linha = br.readLine()) != null) {
                if (matriz == null) {
                    largura = linha.length();
                    matriz = new Celula[10][10]; // Ajuste se necessário
                }
                for (int i = 0; i < largura; i++) {
                    matriz[i][linhas] = new Celula(getObjetoPorSimbolo(linha.charAt(i), i, linhas));
                }
                linhas++;
            }
            altura = linhas;
        } catch (IOException e) {
            System.err.println("Erro ao carregar o mapa: " + e.getMessage());
        }
    }
    
    //Método para revelar campo de visão do jogador
    public void revelaCampoVisao(Jogador jogador){
        //Reseta visao
        this.esconderTodasCelulas();
        
        int jogadorX = jogador.getPosicao()[0];
        int jogadorY = jogador.getPosicao()[1];
        
        //Revela na direção esquerda
        for(int x = jogadorX - 1; x>= 0; x--){
            if(!revelarCelula(x, jogadorY)){
                break;
            }
        }
        
        //Revela na direção direita
        for(int x = jogadorX + 1; x<matriz[0].length; x++){
            if(!revelarCelula(x, jogadorY)){
                break;
            }
        }
        
        //Revela na direção cima
        for(int y = jogadorY - 1; y >= 0; y--){
            if(!revelarCelula(jogadorX, y)){
                break;
            }
        }
        
        //Revela na direção baixo
        for(int y = jogadorY + 1; y<matriz.length; y++){
            if(!revelarCelula(jogadorX, y)){
                break;
            }   
        }
        
        matriz[jogadorY][jogadorX].setRevelada(true);
    }
    
    public boolean revelarCelula(int x, int y){
        Celula celula = matriz[y][x];
        celula.setRevelada(true);
        
        ObjetoMapa objeto = celula.getObjeto();
        return (objeto instanceof Vazio);
    }
    public void exibirMapa() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void esconderTodasCelulas(){
        for(int i = 0; i < altura; i++){
            for (int j = 0; j < largura; j++) {
                matriz[i][j].setRevelada(false);
            }
        }
    }
    
     public Celula[][] getMatriz() {
        return matriz;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
    public ObjetoMapa getObjetoPorSimbolo(char simbolo, int x, int y){
        try{
            switch(simbolo){
                case 'Z', 'R', 'C', 'G' -> {
                    return new ZumbiComum(x, y);
                }
                case 'J' -> {
                    return new Jogador(5, x, y, this.percepcao, this);
                }
                case 'P' -> {
                    return new Parede(x, y);
                }
                case 'V' -> {
                    return new Vazio(x, y);
                }
                case 'B' -> {
                    return new Bau(x, y);
                }
                default -> throw new Exception(simbolo + " não é um símbolo aceito pelo mapa");
            }
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro ao buscar objeto por símbolo: " + e.getMessage());
            return null;
        }
    }
    
    public boolean ehPosicaoValida(int x, int y){
        if(!(x > 9 || x < 0 || y > 9 || y < 0)){
            if(matriz[y][x].getObjeto() instanceof Parede){
                System.out.println("Parede");
                return false;
            }else{
                return true;
            }
        }
        System.out.println("Posição invalida!");
        return false;
    }
    
    public boolean ehZumbi(int x, int y){
        return matriz[x][y].getObjeto() instanceof Zumbi;
    }
    
    private Jogador encontrarJogador(){
        for(int i = 0; i < altura; i++){
            for(int j = 0; j < largura; j++){
                ObjetoMapa objeto = matriz[i][j].getObjeto();
                if(objeto instanceof Jogador){
                    return (Jogador) objeto;
                }
            }
        }
        return null;
    }
    
    public Jogador getJogador(){
        return this.jogador;
    }
}
