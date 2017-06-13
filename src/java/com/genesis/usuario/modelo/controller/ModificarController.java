/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.usuario.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Ismael
 */
@Named(value = "modificarController")
@SessionScoped
public class ModificarController implements Serializable {

    @EJB
    private UsuarioFacadeLocal ufl;
    
    private Usuario usuarioSeleccionado;
    
    
    /**
     * Creates a new instance of ModificarController
     */
    public ModificarController() {
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public void actulaizarDatos(){
        try {
            ufl.edit(usuarioSeleccionado);
            MessageUtil.enviarMensajeInformacion("listar-usuarios", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al modificar los datos del usuario", e.getStackTrace().toString());
        }
    }
    
    public String preModificar(Usuario u){
        setUsuarioSeleccionado(u);
        return "/app/usuarios/editar.xhtml?faces-redirect=true";
    }
    
    public void cambioDeEstado(Usuario u){
        try {
            if (u.getEstado() == 1) {
                u.setEstado((short)2);
            } else {
                u.setEstado((short)1);
            }
            ufl.edit(u);
            MessageUtil.enviarMensajeInformacion("listar-usuarios", "Actualización", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeErrorGlobal("Err cambiar el estado del usuario", e.getStackTrace().toString());
        }
        
        
    }
    
    public String getIconUsuarioBloqueo(Usuario u){
        return (u.getEstado() == 1) ? "lock": "unlock";
    }
}
