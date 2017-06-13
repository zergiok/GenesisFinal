/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;

import com.genesis.modelo.entities.Permiso;
import com.genesis.modelo.entities.Rol;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author zergiok
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

   @EJB
    private SessionRule sr;
    
    private String clave;
    private Long cedula;
    private Rol rolSeleccionado;
    private Usuario usuario;
    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String iniciarSesion(){
        String urlDestino = "";
        usuario = sr.iniciar(cedula, clave);
        if(usuario != null){
            rolSeleccionado = sr.validarRol(usuario);
            if(rolSeleccionado != null){
                urlDestino = "/app/home.xhtml?faces-redirect=true";
            } else{
                System.out.println("No se encontro el usuario");
                usuario = null;
            }
        }
        return urlDestino;
    }
    public String cerrarSesion(){
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        rolSeleccionado = null;
        clave = "";
        cedula = null;
        
        return "/login.xhtml?faces-redirect=true";
    }
    
    public Boolean inicioSesion(){
        return (usuario != null);
    }
    
    public Boolean tienePermiso(String urlRecurso){
        if(urlRecurso.endsWith("app/home.xhtml")){
            return true;
        }
        for (Permiso p : rolSeleccionado.getPermisos()) {
            if(p.getUrl() != null && urlRecurso.endsWith(p.getUrl())){
                return true;
            }
        }
        return false;
    }
    
    
    @PreDestroy
    public void perDestroy(){
        cerrarSesion();
    }
    
//IDIOMAS IDIOMAS IDIOMAS

 

    private Locale languageSelected;
    
    /**
     * Creates a new instance of SessionController
     */

    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Locale idiomaUsuario = ec.getRequestLocale();
        boolean support = false;
        for (Locale l : getSupportLanguages()) {
            if(l.getLanguage().equals(idiomaUsuario.getLanguage())){
                support = true; break;
            }
        }
        languageSelected = (support) ? idiomaUsuario: new Locale("es");
        
    }

    public Locale getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(Locale languageSelected) {
        this.languageSelected = languageSelected;
    }
    
    public List<Locale> getSupportLanguages(){
        List<Locale> idiomas = new ArrayList<>();
        Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while(it.hasNext()){
            idiomas.add(it.next());
        }
        return idiomas;
    }
    
    public String cambiarIdioma(Locale idioma){
        if(idioma != null){
            this.languageSelected = idioma;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(languageSelected);
        }
        return "";
    }
    
}

