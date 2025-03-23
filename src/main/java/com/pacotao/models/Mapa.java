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

    public Mapa(String caminhoArquivo, int percepcao) {
        this.percepcao = percepcao;
        carregarMapa(caminhoArquivo);
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
                    matriz[linhas][i] = new Celula(getObjetoPorSimbolo(linha.charAt(i), i, linhas));
                }
                linhas++;
            }
            altura = linhas;
        } catch (IOException e) {
            System.err.println("Erro ao carregar o mapa: " + e.getMessage());
        }
    }
    
    public void exibirMapa() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
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
                case 'Z':
                case 'R':
                case 'C':
                case 'G':
                    return new ZumbiComum(x, y);
                case 'J':
                    return new Jogador(5, x, y, this.percepcao);
                case 'P':
                    return new Parede(x, y);
                case 'V':
                    return new Vazio(x, y);
                case 'B':
                    return new Bau(x, y);
                default:
                    throw new Exception(simbolo + " não é um símbolo aceito pelo mapa");
            }
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro ao buscar objeto por símbolo: " + e.getMessage());
            return null;
        }
    }
    
}
