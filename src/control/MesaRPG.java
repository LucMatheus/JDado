/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Dado;

/**
 *
 * @author Luc
 */
public class MesaRPG {
    public static void mostrarResultado(Dado dado, JLabel etiqueta){
        dado.sortearNumero();
        etiqueta.setText(String.valueOf((int) dado.getNumeroSorteado()));
    }
    public static void mudarValorDoDado(Dado dado) {
        String novoValor = JOptionPane.showInputDialog(null, "Coloque o novo valor das facetas do dado e aperte OK (entre 6 e 120)", "Novo dado", JOptionPane.INFORMATION_MESSAGE);
        novoValor = novoValor.trim();
        
        Byte novoValorEmNumero = 0;
        try {
            novoValorEmNumero = Byte.valueOf(novoValor);
        }
        catch (NumberFormatException erroDeFormatacao) {
            if (novoValor != null) {
                JOptionPane.showMessageDialog(null, "Valor incorreto, tente novamente", "Erro de valor", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro : " + erroDeFormatacao.getMessage());
            }
        }
        
        if (novoValor == null || "".equals(novoValor)) {
            novoValorEmNumero = dado.getNumeroFacetas();
        }
        
        if (novoValorEmNumero < 6) {
            JOptionPane.showMessageDialog(null, "Como o valor colocado é inferior ao de seis, então o dado construido será o de seis lados já que deve ser impossível existir um dado que não seja no mínimo um de seis faces.", "Valor incoerente", JOptionPane.WARNING_MESSAGE);
        }
        else if (novoValorEmNumero > 120 && novoValorEmNumero < 127) {
            JOptionPane.showMessageDialog(null, "Como o valor colocado é superior ao de cento e vinte, então o dado construido será um de cento e vinte, já deve ser louco um dado de cem faces na sua imaginação, apenas um alerta por questão de otimização a folga é até 127 se você passar desse valor, esse programa retornará um erro. bom proveito", "Valor incoerente", JOptionPane.WARNING_MESSAGE);
        }
        dado.setNumeroFacetas(novoValorEmNumero);
    }
    public static void chamarAsInformacoesDaLicenca(JDialog licenca) {
        licenca.setLocation(600, 400);
        licenca.setSize(640, 390);
        licenca.setVisible(true);
    }
    public static void reportarUmBug() {
        /*try {
            Runtime.getRuntime().exec("start www.github.com/LucMatheus/DadoRPGJava/issues/");
        } catch (IOException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }*/
        System.out.println("Em construção");
    }
}
