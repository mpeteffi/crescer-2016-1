/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murillo.peteffi
 */
@Entity
@Table(name = "PESSOA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.findByNmPessoa", query = "SELECT p FROM Pessoa p WHERE p.nmPessoa = :nmPessoa")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PESSOA", nullable = false, precision = 19, scale = 0)
    private BigDecimal idPessoa;
    @Basic(optional = false)
    @Column(name = "NM_PESSOA", nullable = false, length = 255)
    private String nmPessoa;

    public Pessoa() {
    }

    public Pessoa(BigDecimal idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(BigDecimal idPessoa, String nmPessoa) {
        this.idPessoa = idPessoa;
        this.nmPessoa = nmPessoa;
    }

    public BigDecimal getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(BigDecimal idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula5.Pessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
