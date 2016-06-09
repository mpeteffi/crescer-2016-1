package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author murillo.peteffi
 */
public class PessoaRepositorio implements IPessoa {

    @Override
    public void insert(Pessoa pessoa) {
        
        final String query = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + " VALUES ((SELECT MAX(ID_PESSOA) +1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        
             preparedStatement.setString(1, pessoa.getNome());
             preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        
        final String query = "UPDATE PESSOA SET NM_PESSOA = ? "
                + "WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        
             preparedStatement.setString(1, pessoa.getNome());
             preparedStatement.setInt(2, pessoa.getIdPessoa());
             preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        
        final String query = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final PreparedStatement preparedStatement = connection.prepareStatement(query)){
                         
            preparedStatement.setInt(1, pessoa.getIdPessoa());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        
        final String query = "SELECT * FROM PESSOA ORDER BY ID_PESSOA";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(query)){
                         
            while (rs.next()) {
                pessoas.add(new Pessoa(rs.getString("NM_PESSOA"), rs.getInt("ID_PESSOA")));
            }
            
            return pessoas;
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        return null;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        List<Pessoa> pessoas = new ArrayList<>();
        
        final String query = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";
        
        try (final Connection connection = ConnectionUtils.getConnection() ;
             final PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            preparedStatement.setString(1, "%" + nome + "%");
            
            try (final ResultSet rs = preparedStatement.executeQuery()){
                while (rs.next()) {
                    pessoas.add(new Pessoa(rs.getString("NM_PESSOA"), rs.getInt("ID_PESSOA")));
                }            
            } catch (Exception e) {
                //...
            }
                
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        return pessoas;
    }
}
