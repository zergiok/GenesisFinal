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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zergiok
 */
@Entity
@Table(name = "correos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c")
    , @NamedQuery(name = "Correo.findByIdCorreo", query = "SELECT c FROM Correo c WHERE c.idCorreo = :idCorreo")
    , @NamedQuery(name = "Correo.findByCorreoEnviado", query = "SELECT c FROM Correo c WHERE c.correoEnviado = :correoEnviado")
    , @NamedQuery(name = "Correo.findByAsunto", query = "SELECT c FROM Correo c WHERE c.asunto = :asunto")
    , @NamedQuery(name = "Correo.findByContenido", query = "SELECT c FROM Correo c WHERE c.contenido = :contenido")
    , @NamedQuery(name = "Correo.findByDestino", query = "SELECT c FROM Correo c WHERE c.destino = :destino")
    , @NamedQuery(name = "Correo.findByEnviado", query = "SELECT c FROM Correo c WHERE c.enviado = :enviado")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCorreo")
    private Integer idCorreo;
    @Size(max = 45)
    @Column(name = "correoEnviado")
    private String correoEnviado;
    @Size(max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 45)
    @Column(name = "contenido")
    private String contenido;
    @Size(max = 45)
    @Column(name = "destino")
    private String destino;
    @Size(max = 45)
    @Column(name = "enviado")
    private String enviado;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario cedula;

    public Correo() {
    }

    public Correo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public Correo(Object object, String correoRemi, String asunto, String mensaje, String email, String si, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getCorreoEnviado() {
        return correoEnviado;
    }

    public void setCorreoEnviado(String correoEnviado) {
        this.correoEnviado = correoEnviado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public Usuario getCedula() {
        return cedula;
    }

    public void setCedula(Usuario cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.genesis.modelo.entities.Correo[ idCorreo=" + idCorreo + " ]";
    }
    
}
