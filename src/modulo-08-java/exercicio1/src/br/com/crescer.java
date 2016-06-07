package br.com;

import java.util.Scanner;

/**
 * @author murillo.peteffi
 */
public class crescer {


    public static void main(String[] args) {
        
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();
            String parimpar = numero%2 == 0 ? "par" : "impar";
            System.out.println("O numero " + numero + " é " + parimpar + ".");
        } catch (Exception e) {
            // 
        }
        
    }
    
}
