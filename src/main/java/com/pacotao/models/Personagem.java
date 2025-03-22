/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */
public abstract class Personagem extends ObjetoMapa {
    protected int saude; // HP do personagem

    public Personagem(String simbolo, String caminhoImagem, int saude, int x, int y) {
        super(simbolo, caminhoImagem, x, y);
        this.saude = saude;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }
}
