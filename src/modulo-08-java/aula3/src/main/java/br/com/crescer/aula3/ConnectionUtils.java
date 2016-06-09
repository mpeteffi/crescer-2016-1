package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author murillo.peteffi
 */
public class ConnectionUtils {
    
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER = "CRESCER16";
    public static final String PASS = "CRESCER16";
    
    public static Connection  getConnection() throws SQLException {
        
        final Connection connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;        
    }
}
