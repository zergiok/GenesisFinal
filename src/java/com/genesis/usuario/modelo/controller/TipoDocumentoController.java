/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.usuario.modelo.controller;

import com.genesis.modelo.entities.Tipodocumento;
import com.genesis.modelo.facade.TipodocumentoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ismael
 */
@Named(value = "tipoDocumentoController")
@RequestScoped
public class TipoDocumentoController {

    @EJB
    private TipodocumentoFacadeLocal tdfl;
    
    private List<Tipodocumento> tiposDeDocumentos;
    /**
     * Creates a new instance of TipoDocumentoController
     */
    public TipoDocumentoController() {
    }
    
    @PostConstruct
    public void init(){
        tiposDeDocumentos = tdfl.findAll();
    }

    public List<Tipodocumento> getTiposDeDocumentos() {
        return tiposDeDocumentos;
    }
    
    
}
