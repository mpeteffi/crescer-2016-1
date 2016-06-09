package br.com.crescer.aula3;

/**
 * @author murillo.peteffi
 */
public class Pessoa {
    
    public Pessoa(String nome, int id){
        this.nome = nome;
        this.idPessoa = id;
    } 
    
    private String nome;
    private int idPessoa;
       
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}
