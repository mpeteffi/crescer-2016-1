package br.com.crescer.aula2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author murillo.peteffi
 */
public class Run {
    
    public static BufferedReader getReader(String file) throws FileNotFoundException{
        return new BufferedReader(new FileReader(file));
    }
    
    public static BufferedWriter getWriter(String file) throws IOException{       
        return new BufferedWriter(new FileWriter(file, true));
    }
    
    public static void main(String[] args) {
               
        new Thread (new Runnable(){
            @Override
            public void run(){
                BufferedReader bufferReader = null;
                try {
                    bufferReader = Run.getReader("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                    while(true){
                        String readLine = bufferReader.readLine();
                        if(readLine != null){
                            System.out.println(readLine);
                        }
                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    //
                } finally {
                    try {
                        if(bufferReader != null){
                            bufferReader.close();
                        }
                    } catch (IOException e) {
                        //
                    }
                }
            }
        }).start();
        
        while(true){
            Scanner scanner = new Scanner(System.in);
            String texto = scanner.nextLine();
            String dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            String nextLine = dataAtual + " - " + "" + "" + texto;
            
            if(":q!".equals(nextLine)){
                break;
            }
            
            BufferedWriter bufferWriter = null;
            try{
                bufferWriter = getWriter("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                bufferWriter.write(nextLine);
                bufferWriter.newLine();
                bufferWriter.flush();
                
            } catch (Exception e){
                //
            } finally {
                try {
                    if(bufferWriter != null) {
                        bufferWriter.close();
                    }
                } catch (Exception e) {
                    //
                }
            }
        }
    }       
}