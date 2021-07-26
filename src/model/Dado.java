/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * Simula o dado básico, não viciado de um RPG de mesa.
 * OBS: Nesse programa o dado tem um limite de até <b>120</b> faces
 * @author Lucas Matheus Costa
 * @version 1.0.0
 */
public class Dado {
    
    //Atributos
    private byte numeroFacetas;
    private byte numeroSorteado;
    private final byte VALOR_PADRAO = 6;
    private final byte VALOR_MAXIMO = 120;
    //Construtor
    public Dado(byte facetas){
        try {
            this.numeroFacetas = this.validarLimiteDosDados(facetas);
        } catch (NumberFormatException erroDeFormato) {
            System.out.println("Número de faces não declarado");
            System.out.println("Implementando um dado comum de seis faces não viciado");
            this.numeroFacetas = (byte) 6;
        }
        System.out.println("Dado implementado com sucesso");
    }
    
    //Metodos
    /**
     * Sortear o número do dado.
     */
    public void sortearNumero(){
        Random numeroAleatorio = new Random();
        this.setNumeroSorteado((byte) numeroAleatorio.nextInt(this.numeroFacetas+1));
    }

    public void setNumeroFacetas(byte numeroFacetas) {
        this.numeroFacetas = this.validarLimiteDosDados(numeroFacetas);
    }
    public void setNumeroSorteado(byte numeroSorteado) {
        if (numeroSorteado < 1) {
            this.numeroSorteado = 1;
        } 
        else {
            this.numeroSorteado = numeroSorteado;
        }
    }
    public byte getNumeroFacetas() {
        return numeroFacetas;
    }
    public byte getNumeroSorteado() {
        return this.numeroSorteado;
    }
    private byte validarLimiteDosDados(byte numeroDesejado) {
        byte numeroValidado = 0;
        // Caso venha um número menor que seis
        if (numeroDesejado < VALOR_PADRAO) {
            numeroValidado = VALOR_PADRAO;
            System.out.println("O dado tem um valor bastante inferior ao minimo, então será construido um dado de "+VALOR_PADRAO+" faces");
        }
        // Caso venha um número maior que cento e vinte.
        else if (numeroDesejado > VALOR_MAXIMO) {
            numeroValidado = VALOR_MAXIMO;
            System.out.println("O dado tem um valor bastante superior ao máximo, então será construido um dado de "+VALOR_MAXIMO+" faces");
        }
        // Situação habitual
        else {
            numeroValidado = numeroDesejado;
        }
        System.out.println("Dado alterado com sucesso");
        return numeroValidado;
    }
   
}
