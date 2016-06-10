package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author murillo.peteffi
 */
public class MeuSQLUtils {
    
    public void executeFromFile(String file) {
        if(file.endsWith(".sql")) {
            try (Reader reader = new FileReader(file);
                BufferedReader bufferReader = new BufferedReader(reader)){
                String line = "";
                
                while (line != null) {
                    
                    line = bufferReader.readLine();
                    System.out.println(line);
                    
                    if(line != null){
                    
                        try(final Connection connection = ConnectionUtils.getConnection();
                            final Statement statement = connection.createStatement()){
                            
                            statement.executeUpdate(line);

                        }catch (SQLException e) {
                            System.err.format("SQLException: %s", e);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Arquivo não encontrado.");
            } 
        }
    }
}
