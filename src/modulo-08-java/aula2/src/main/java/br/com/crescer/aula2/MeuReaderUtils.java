package br.com.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Murillo
 */
public class MeuReaderUtils {
    
    public static void main(String[] args){
        exibirConteudo("aula.txt");
    }
    
    public static void exibirConteudo(String arquivo){
        BufferedReader bufferReader = null;
         
        try {
            if (arquivo.lastIndexOf(".txt") == -1) {
                System.out.println("O arquivo deve ser .txt");
            } else {
                bufferReader = new BufferedReader(new FileReader(arquivo));
                String linha = "";
                
                try {
                    while (linha != null){
                        if(!linha.isEmpty()){
                            System.out.println(linha);
                        }
                        linha = bufferReader.readLine();
                    } 
                } catch (IOException e) {
                    //
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }
}
