package com.mycompany.crescer16.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Murillo
 */
@Entity
@Table(name = "CIDADE")
public class Cidade implements Serializable  {
    
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCIDADE")
    @SequenceGenerator(name = "SQCIDADE", sequenceName = "SQCIDADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "UF")
    private String uf;
    
    public Cidade() {}
    
    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }
    
    public Cidade(long id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
