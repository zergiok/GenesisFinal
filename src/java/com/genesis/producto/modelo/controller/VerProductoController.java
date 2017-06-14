/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.producto.modelo.controller;

import com.genesis.modelo.entities.Producto;
import com.genesis.modelo.facade.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "verProductoController")
@SessionScoped //Debemos cambiarlo a @ConversationScoped
public class VerProductoController implements Serializable{

    private Producto producto;
    /**
     * Creates a new instance of ListarUsuariosController
     */
    public VerProductoController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

//    public String verProducto(Producto u){
//        this.producto = u;
//        return "/app/administrador/productos/ver.xhtml?faces-redirect=true";
//    }
    
    
}
