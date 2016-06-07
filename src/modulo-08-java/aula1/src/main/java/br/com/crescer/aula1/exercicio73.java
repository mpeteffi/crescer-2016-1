package br.com.crescer.aula1;

import java.util.Arrays;
import java.util.List;

/**
 * @author murillo.peteffi
 */

public class exercicio73 {
    
    public static void main (String[] args) {
        
        final List<Estados> lista = Arrays.asList(Estados.values());      
        
        StringBuffer listaOrdenada = new StringBuffer("");
        
        String separador = "";
        for(Estados estado : lista){
            listaOrdenada.append(separador).append(estado.getNome());
            separador = ", ";
        }
        
        System.out.println(listaOrdenada);
        
    }
}

