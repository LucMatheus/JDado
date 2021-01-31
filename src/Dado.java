/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Random;

/**
 * Simula o dado básico, não viciado de um RPG de mesa.
 * OBS: Nesse programa o dado tem um limite de até <b>120</b> faces
 * @author Lucas Matheus Costa
 * @version 3.0.1
 */
public class Dado {
    
    //Atributos
    private byte numeroFacetas;
    private byte numeroSorteado;
    
    //Construtor
    public Dado(byte facetas){
        try {
            this.numeroFacetas = this.validarLimiteDosDados(facetas);
        } catch (NumberFormatException erroDeFormato) {
            this.numeroFacetas = (byte) 6;
        }
    }
    
    //Metodos
    /**
     * Sortear o número.
     */
    public byte sortearNumero(){
        Random numeroAleatorio = new Random();
        this.setNumeroSorteado((byte) numeroAleatorio.nextInt(this.numeroFacetas));
        return this.numeroSorteado;
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
    private byte validarLimiteDosDados(byte numeroDesejado) {
        byte numeroValidado = 0;
        // Caso venha um número menor que três
        if (numeroDesejado < 3) {
            numeroValidado = 3;
        }
        // Caso venha um número maior que cento e vinte.
        else if (numeroDesejado > 120) {
            numeroValidado = 120;
        }
        // Situação habitual
        else {
            numeroValidado = numeroDesejado;
        }
        return numeroValidado;
    }
   
}
