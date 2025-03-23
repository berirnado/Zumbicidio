/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package com.pacotao.models;

import java.util.Random;

/**
 *
 * @author Bernardo Robaina
 */
public class Vazio extends ObjetoMapa {
  
    private static final String CAMINHO_BASE = "src/main/java/com/pacotao/imagens/concreto"; // Diretório base da imagem

    public Vazio(int x, int y) {
        super("V", CAMINHO_BASE + (new Random().nextInt(4) + 1) + ".png", x, y);
    }
}
