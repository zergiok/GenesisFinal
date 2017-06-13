/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zergiok
 */
@Entity
@Table(name = "detallespedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepedido.findAll", query = "SELECT d FROM Detallepedido d")
    , @NamedQuery(name = "Detallepedido.findByIddetallespedidos", query = "SELECT d FROM Detallepedido d WHERE d.iddetallespedidos = :iddetallespedidos")
    , @NamedQuery(name = "Detallepedido.findByDetallesPedido", query = "SELECT d FROM Detallepedido d WHERE d.detallesPedido = :detallesPedido")
    , @NamedQuery(name = "Detallepedido.findByCantidad", query = "SELECT d FROM Detallepedido d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallepedido.findByObservacionServicio", query = "SELECT d FROM Detallepedido d WHERE d.observacionServicio = :observacionServicio")})
public class Detallepedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallespedidos")
    private Integer iddetallespedidos;
    @Size(max = 45)
    @Column(name = "detallesPedido")
    private String detallesPedido;
    @Column(name = "cantidad")
    private Short cantidad;
    @Size(max = 45)
    @Column(name = "observacionServicio")
    private String observacionServicio;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido idPedido;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;

    public Detallepedido() {
    }

    public Detallepedido(Integer iddetallespedidos) {
        this.iddetallespedidos = iddetallespedidos;
    }

    public Integer getIddetallespedidos() {
        return iddetallespedidos;
    }

    public void setIddetallespedidos(Integer iddetallespedidos) {
        this.iddetallespedidos = iddetallespedidos;
    }

    public String getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(String detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacionServicio() {
        return observacionServicio;
    }

    public void setObservacionServicio(String observacionServicio) {
        this.observacionServicio = observacionServicio;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallespedidos != null ? iddetallespedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepedido)) {
            return false;
        }
        Detallepedido other = (Detallepedido) object;
        if ((this.iddetallespedidos == null && other.iddetallespedidos != null) || (this.iddetallespedidos != null && !this.iddetallespedidos.equals(other.iddetallespedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.genesis.modelo.entities.Detallepedido[ iddetallespedidos=" + iddetallespedidos + " ]";
    }
    
}
