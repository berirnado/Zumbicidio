/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.models;

import java.util.*;

/**
 *
 * @author Bernardo Robaina
 */

public class Bau extends ObjetoMapa{
    private static List<Item> items = new ArrayList<>(List.of(
        new Arma("Revolver", 2, 4),
        new Medicamento("Medicamento", 1),
        new Medicamento("Medicamento", 1),
        new Arma("Taco", 2, 100),
        new Arma("Revolver", 2, 1),
        new Arma("Z", 999, 999) // ZUMBI MIMIC
    ));
    private Random random = new Random();
    
    public Bau(int x, int y){
        super("B", x, y);
        this.setImagem(gerarImagem());
    }
    
    @Override
    public String gerarImagem(){
        String stringRetorno = "src/main/java/com/pacotao/imagens/bau.png";
        return stringRetorno;
    }
    
    public Item abrir(){
        if (!items.isEmpty()) {
            Item itemRetorno = items.get(random.nextInt(items.size()));
            items.remove(itemRetorno);
            return itemRetorno; // Retorna um item aleatório
        }
        return null; // Retorna null se a lista estiver vazia
    }
}
