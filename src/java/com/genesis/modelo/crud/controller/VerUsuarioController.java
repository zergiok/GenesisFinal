/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.crud.controller;

import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
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
 * @author Ismael
 */
@Named(value = "verUsuarioController")
@SessionScoped //Debemos cambiarlo a @ConversationScoped
public class VerUsuarioController implements Serializable{

    private Usuario usuario;
    /**
     * Creates a new instance of ListarUsuariosController
     */
    public VerUsuarioController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String verUsuario(Usuario u){
        this.usuario = u;
        return "/app/usuarios/veru.xhtml?faces-redirect=true";
    }
    
    
}
