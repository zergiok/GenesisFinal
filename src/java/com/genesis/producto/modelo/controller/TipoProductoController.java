/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.producto.modelo.controller;

import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.facade.TipoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "tipoProductoController")
@RequestScoped
public class TipoProductoController {

    @EJB
    private TipoFacadeLocal tdfl;
    
    private List<Tipo> tipoProductos;
    /**
     * Creates a new instance of TipoDocumentoController
     */
    public TipoProductoController() {
    }
    
    @PostConstruct
    public void init(){
        tipoProductos = tdfl.findAll();
    }

    public List<Tipo> getTiposProductos() {
        return tipoProductos;
    }
    
    
}
