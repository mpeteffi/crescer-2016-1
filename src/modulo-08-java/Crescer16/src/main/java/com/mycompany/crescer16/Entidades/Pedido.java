package com.mycompany.crescer16.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Murillo
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private long id;

    @OneToOne
    @JoinColumn(name = "IDCLIENTE")
    @Basic(optional = false)
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    private Date dataPedido;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATAENTREGA")
    private Date dataEntrega;
    
    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private double valorPedido;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @OneToMany
    @JoinColumn(name = "IDPEDIDO")
    @Basic(optional = false)
    private List<PedidoItem> itens;
        
    public Pedido() {}

    public Pedido(Cliente cliente, Date dataPedido, Date dataEntrega, double valorPedido, char situacao, List<PedidoItem> pedidoItem) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.valorPedido = valorPedido;
        this.situacao = situacao;
        this.itens = pedidoItem;
    }
    
    public Pedido(long id, Cliente cliente, Date dataPedido, Date dataEntrega, double valorPedido, char situacao, List<PedidoItem> pedidoItem) {
        this(cliente, dataPedido, dataEntrega, valorPedido, situacao, pedidoItem);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }
}
