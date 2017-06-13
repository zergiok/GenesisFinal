/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;

import com.genesis.modelo.entities.Correo;
import com.genesis.modelo.controller.SessionController;
import com.genesis.modelo.facade.CorreoFacadeLocal;
import com.genesis.modelo.controller.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author zergiok
 */
@Named(value = "listarCorreosController")
@ViewScoped
public class ListarEmailController implements Serializable{

    
    
    @EJB
    private CorreoFacadeLocal ucl;
    
    private List<Correo> correos;
    
    private Correo correoSeleccionado;
    /**
     * Creates a new instance of ListarCorreosController
     */
    public ListarEmailController() {
    }
    
    @PostConstruct
    public void init(){
        recargarCorreos();
    }
    
    private void recargarCorreos(){
        correos = ucl.findAll();
    }

    public List<Correo> getCorreos() {
        return correos;
    }

    public CorreoFacadeLocal getUfl() {
        return ucl;
    }

    public void setUfl(CorreoFacadeLocal ucl) {
        this.ucl = ucl;
    }

    public Correo getCorreoSeleccionado() {
        return correoSeleccionado;
    }

    
    
   
    
}
    