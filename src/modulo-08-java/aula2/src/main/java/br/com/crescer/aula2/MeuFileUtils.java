package br.com.crescer.aula2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Murillo
 */
public class MeuFileUtils {
    
    public static void main(String[] args) {
        
        try {
            switch(args[0]) {
                case "mk":
                    criar(args[1]);
                break;
                case "ls":
                    caminhoAbsoluto(args[1]);
                break;
                case "rm":
                    deletar(args[1]);
                break;
                case "mv":
                    mover(args[1], args[2]);
                break;
            }
        } catch(Exception e) {
            //
        }
    }
    
    public static void criar(String file) {
        
        try {
            new File(file).createNewFile();
            
        } catch (IOException e) {
            //
        }
    }
    
    public static void caminhoAbsoluto(String file) {
        
        File arquivo = new File(file);
        System.out.println(arquivo.getAbsolutePath());
        
        if(arquivo.isDirectory()) {
            
            for(File arq: arquivo.listFiles()){
                System.out.println(arq.getName());
            }
        } 
    }
    
    public static void mover(String file, String caminhoNovo) {
        
        File arquivo = new File(file);
        File caminhoNovoFile = new File(caminhoNovo + arquivo);
        
        try {
            Files.move(arquivo.toPath(), caminhoNovoFile.toPath());
        } catch (Exception e) { 
            // 
        }
    }
    
    private static void deletar(String file) {
        
        File arquivo = new File(file);
        
        if(arquivo.isFile())
            arquivo.delete();
    }
}
