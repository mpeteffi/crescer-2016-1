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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author murillo.peteffi
 */
@Entity
@Table(name = "PRODUTOMATERIAL")
@NamedQueries({
    @NamedQuery(name = "ProdutoMaterial.findAll", query = "SELECT p FROM ProdutoMaterial p"),
    @NamedQuery(name = "ProdutoMaterial.findByIdprodutomaterial", query = "SELECT p FROM ProdutoMaterial p WHERE p.idprodutomaterial = :idprodutomaterial"),
    @NamedQuery(name = "ProdutoMaterial.findByQuantidade", query = "SELECT p FROM ProdutoMaterial p WHERE p.quantidade = :quantidade")})
public class ProdutoMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private BigDecimal idprodutomaterial;
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @JoinColumn(name = "IDMATERIAL", referencedColumnName = "IDMATERIAL")
    @ManyToOne(optional = false)
    private Material idmaterial;
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne(optional = false)
    private Produto idproduto;

    public ProdutoMaterial() {
    }

    public ProdutoMaterial(BigDecimal idprodutomaterial) {
        this.idprodutomaterial = idprodutomaterial;
    }

    public BigDecimal getIdprodutomaterial() {
        return idprodutomaterial;
    }

    public void setIdprodutomaterial(BigDecimal idprodutomaterial) {
        this.idprodutomaterial = idprodutomaterial;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Material getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(Material idmaterial) {
        this.idmaterial = idmaterial;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutomaterial != null ? idprodutomaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoMaterial)) {
            return false;
        }
        ProdutoMaterial other = (ProdutoMaterial) object;
        if ((this.idprodutomaterial == null && other.idprodutomaterial != null) || (this.idprodutomaterial != null && !this.idprodutomaterial.equals(other.idprodutomaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula5.ProdutoMaterial[ idprodutomaterial=" + idprodutomaterial + " ]";
    }
    
}
