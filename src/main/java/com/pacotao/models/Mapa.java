/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.util.*;

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
    
    private boolean ehDebug;

    public Mapa(String caminhoArquivo, int percepcao, boolean ehDebug) {
        this.ehDebug = ehDebug;
        this.percepcao = percepcao;
        carregarMapa(caminhoArquivo);
        this.jogador = this.encontrarJogador();
        if (!ehDebug){
            this.revelaCampoVisao(jogador);
        }
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
                    Celula cel = new Celula(getObjetoPorSimbolo(linha.charAt(i), linhas, i));
                    matriz[i][linhas] = cel;
                    if(ehDebug){
                        cel.setRevelada(true);
                    }
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
        if(this.percepcao >= 2){
            this.revelarPrimeiraCasaDiagonal(this.getJogador());
        }
    }
    
    // Revela a primeira casa em cada diagonal a partir da posição do jogador
    public void revelarPrimeiraCasaDiagonal(Jogador jogador) {
        int jogadorX = jogador.getPosicao()[0]; // Coluna do jogador
        int jogadorY = jogador.getPosicao()[1]; // Linha do jogador

        // Revela a célula na diagonal noroeste (NW)
        revelarCelulaDiagonal(jogadorY - 1, jogadorX - 1);

        // Revela a célula na diagonal nordeste (NE)
        revelarCelulaDiagonal(jogadorY - 1, jogadorX + 1);

        // Revela a célula na diagonal sudoeste (SW)
        revelarCelulaDiagonal(jogadorY + 1, jogadorX - 1);

        // Revela a célula na diagonal sudeste (SE)
        revelarCelulaDiagonal(jogadorY + 1, jogadorX + 1);
    }

    // Revela uma célula e retorna true se a célula for vazia (ou seja, a visão pode continuar)
    private boolean revelarCelulaDiagonal(int y, int x) {
        // Verifica se a posição (y, x) está dentro dos limites da matriz
        if (y >= 0 && y < altura && x >= 0 && x < largura) {
            Celula celula = matriz[y][x]; // y é a linha, x é a coluna
            celula.setRevelada(true); // Revela a célula
        }
        return false; // Fora dos limites do mapa
    }
    
    

    
    public boolean revelarCelula(int x, int y){
        Celula celula = matriz[y][x];
        celula.setRevelada(true);
        
        ObjetoMapa objeto = celula.getObjeto();
        return (objeto instanceof Vazio);
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
                case 'Z' -> {
                    ZumbiComum zumbi = new ZumbiComum(x,y);
                    zumbi.adicionaZumbi(zumbi);
                    return zumbi;
                }
                case 'R' -> {
                    ZumbiRastejante zumbi = new ZumbiRastejante(x,y);
                    zumbi.adicionaZumbi(zumbi);
                    return zumbi;
                }
                case 'C' -> {
                    ZumbiCorredor zumbi = new ZumbiCorredor(x,y);
                    zumbi.adicionaZumbi(zumbi);
                    return zumbi;
                }
                case 'G' -> {
                    ZumbiGigante zumbi = new ZumbiGigante(x,y);
                    zumbi.adicionaZumbi(zumbi);
                    return zumbi;
                }
                case 'J' -> {
                    return new Jogador(3, x, y, this.percepcao, this);
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
            ObjetoMapa objetoDestino = matriz[y][x].getObjeto();
            if(objetoDestino instanceof Parede){
                System.out.println("Parede");
                return false;
            }else{
                if(objetoDestino instanceof Bau bau){
                    Item bauRetorno = bau.abrir();
                    System.out.println("Baú");
                    if(bauRetorno.getNome() == "Z"){
                        System.out.println("Zumbi no baú");
                        //Iniciar combate com Zumbi rastejante
                        return true;
                    }
                    System.out.println("Coletou o item " + bauRetorno.getNome());
                    this.jogador.coletarItem(bauRetorno);
                    matriz[y][x].setObjeto(new Vazio(x, y));
                    return true;
                }
                return true;
            }
        }
        System.out.println("Posição invalida!");
        return false;
    }
    
    public boolean ehZumbi(int x, int y){
        if(!(x > 9 || x < 0 || y > 9 || y < 0)){
            return matriz[x][y].getObjeto() instanceof Zumbi;
        }
        else{
            return false;
        }
    }
    
    public Item abreBau(int x, int y){
        if(!(x > 9 || x < 0 || y > 9 || y < 0)){
            if(matriz[y][x].getObjeto() instanceof Bau bau){
                Item bauRetorno = bau.abrir();
                if(bauRetorno.getNome() == "Z"){
                    System.out.println("Zumbi no baú");
                    //Iniciar combate com Zumbi rastejante
                    return null;
                }
                System.out.println("Coletou o item " + bauRetorno.getNome());
                return bauRetorno;
            }else{
                return null;
            }
        }
        return null;
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
