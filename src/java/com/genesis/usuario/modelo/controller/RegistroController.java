/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.usuario.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Rol;
import com.genesis.modelo.entities.Rolusuario;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.RolFacadeLocal;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author zergiok
 */
@Named(value = "registroController")
@RequestScoped
public class RegistroController {

    @EJB
    private UsuarioFacadeLocal ufl;
    @EJB
    private RolFacadeLocal rfl;
    
    private Usuario nuevoUsuario;
    /**
     * Creates a new instance of RegistroController
     */
    public RegistroController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoUsuario = new Usuario();
    }

    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
    
    public void registrar(){
        if(nuevoUsuario != null){
            nuevoUsuario.setRolesusuario(new ArrayList<Rolusuario>());
            Rolusuario ru = new Rolusuario();
            ru.setCedula(nuevoUsuario);
            ru.setIdRol(rfl.find(2));
            ru.setFecha(new Date());
            nuevoUsuario.getRolesusuario().add(ru);
            nuevoUsuario.setEstado((short) 2);
            ufl.create(nuevoUsuario);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "El usuario se ha registrado correctamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError("form-registro", "No se han diligenciado los campos", "");
        }
    }
    
}
