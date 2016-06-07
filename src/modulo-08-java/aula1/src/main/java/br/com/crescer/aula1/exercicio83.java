package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author murillo.peteffi
 */
public class exercicio83 {
    
    public static void main(String[] args){
        
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        String dataAtual = format.format(data); 
        System.out.println(dataAtual);        
    }    
}
