/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.controllers;

import com.pacotao.models.*;
import com.pacotao.views.*;

/**
 *
 * @author Bernardo Robaina
 */

public class JogoController {
    public void iniciarJogo(MainFrame frame, int percepcao){
        System.out.println("Entrou iniciarJogo()");
        Jogo jogo = new Jogo(percepcao);
        jogo.iniciar();
        jogo.setJogador(jogo.getMapa().getJogador());
        frame.criaGamePanel(jogo);
    }
}
