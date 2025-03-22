/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

/**
 *
 * @author Bernardo Robaina
 */

public class Celula {
    private ObjetoMapa objeto; // Pode ser um zumbi, baú, jogador, etc.
    private boolean revelada; // Indica se a célula está visível para o jogador

    public Celula(ObjetoMapa objeto) {
        this.objeto = objeto;
        this.revelada = true; // Por padrão, a célula não está revelada
    }

    public ObjetoMapa getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoMapa objeto) {
        this.objeto = objeto;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }
    
}
