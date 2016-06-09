package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author murillo.peteffi
 */
public class Run {
    
    public static void main (String[] args ){
        
        final String query = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + " VALUES ((SELECT MAX(ID_PESSOA) +1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        
             preparedStatement.setString(1, "PEDRO");
             preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}

