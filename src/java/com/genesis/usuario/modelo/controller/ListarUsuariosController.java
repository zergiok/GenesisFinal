/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.usuario.modelo.controller;


import com.genesis.modelo.controller.SessionController;
import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Ismael
 */
@Named(value = "listarUsuariosController")
@ViewScoped
public class ListarUsuariosController implements Serializable{

    @Inject
    private SessionController sc;
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    private List<Usuario> usuarios;
    
    private Usuario usuarioSeleccionado;
    /**
     * Creates a new instance of ListarUsuariosController
     */
    public ListarUsuariosController() {
    }
    
    @PostConstruct
    public void init(){
        recargarUsuarios();
    }
    
    private void recargarUsuarios(){
        usuarios = ufl.findAll();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public UsuarioFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuarioFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        System.out.println("Usuario - " + usuarioSeleccionado.getCedula());
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public void eliminarUsuario(){
        Usuario uS = sc.getUsuario();
//        System.out.println("El usuario que inicio sesión es: " + uS.getPrimerNombre());
//        System.out.println("Voy a eliminar el usuario: " + usuarioSeleccionado.getPrimerNombre());
        if(uS.getCedula().intValue() != usuarioSeleccionado.getCedula()){
            ufl.remove(usuarioSeleccionado);
            recargarUsuarios();
            MessageUtil.enviarMensajeInformacion("listar-usuarios", "Eliminacion correcta", "El usuario se ha eliminado correctamente.");
        } else{
            MessageUtil.enviarMensajeError(null, "Error al eliminar", "No puede elimarse usted mismo");
        }
    }
    
}
