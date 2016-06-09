package br.com.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Murillo
 */
public class MeuWriterUtils {
    
    public static void main(String[] args){
        List<String> texto = new ArrayList<>(Arrays.asList("abc", "def", "teste", "linha4"));
        escrever("aula.txt", texto);
        
        MeuReaderUtils.exibirConteudo("aula.txt");
    }
    
    public static void escrever(String arquivo, List<String> texto){
        BufferedWriter bufferWriter = null;
         
        try {
            if (arquivo.lastIndexOf(".txt") == -1) {
                System.out.println("O arquivo deve ser .txt");
            } else {                
                try {
                    bufferWriter = new BufferedWriter(new FileWriter(arquivo));
                    
                    for(String linha : texto){
                        bufferWriter.write(linha);
                        bufferWriter.newLine();
                        bufferWriter.flush();
                    }
                    
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo não encontrado");
                }
            }
        }  catch (IOException e) {
            //            
        } finally {
            if (bufferWriter != null) {
                try {
                    bufferWriter.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }
}
