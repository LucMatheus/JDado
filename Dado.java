/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dado_rpg;

/**
 * Simula o dado básico, não viciado de um RPG de mesa.
 * @param facetas - o número de faces que o dado irá possuir<br/> 
 * OBS: Nesse programa o dado tem um limite de até <b>250</b> faces
 * @author Lucas Matheus Costa
 */
public class Dado {
    
    //Atributos
    protected byte numeroFacetas;
    protected byte numeroSorteado;
    
    //Construtor
    public Dado(byte facetas){
        if(facetas > 250 || facetas <= -250){
            this.numeroFacetas = (byte) 250;
        } else if(facetas < 0){
            this.numeroFacetas = (byte) (facetas*-1);
        } else {
            this.numeroFacetas = (byte) facetas;
        }
    }
    
    //Metodos
    
    /**
     * Sortear o número.
     */
    public void sortearNumero(){
        this.numeroSorteado = (byte) (1 + Math.random() * (this.numeroFacetas - 1)) ;
    }
    /**
     * Exibir o número sorteado.
     * @return o número sorteado.
     */
    public byte mostrarNumero(){
        return this.numeroSorteado;
    }

    public void setNumeroFacetas(byte numeroFacetas) {
       if (numeroFacetas > 250 || numeroFacetas <= -250){
           this.numeroFacetas = (byte) 250;
       } else if (numeroFacetas < 0){
           this.numeroFacetas = (byte) (numeroFacetas*-1);
       } else {
           this.numeroFacetas = numeroFacetas;
       }
    }
    
   
}
