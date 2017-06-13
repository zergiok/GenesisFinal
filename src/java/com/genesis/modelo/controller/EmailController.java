/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;


import com.genesis.modelo.controller.util.EnviarEmail;
import com.genesis.modelo.facade.CorreoFacadeLocal;
import com.genesis.modelo.entities.Correo;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.controller.util.MessageUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author zergiok
 */
@Named(value = "controllerEmail")
@SessionScoped
public class EmailController implements Serializable{
    @Inject
    private SessionController sc;
   
    private String nombresyAp;
    private String telefono;
    private String email;
    private String asunto;
    private String mensaje;
    private String correoRemi;
    private String claveRemi;
    private EnviarEmail enviaremail;
    private Correo correoenvia;
    private Usuario useremail;
    @EJB
    private CorreoFacadeLocal cfl;
    
    /**
     * Creates a new instance of ControllerEmail
     */
    public EmailController() {
    }
    
    @PostConstruct
    public void init(){
    enviaremail = new EnviarEmail();
    }

    public String getNombresyAp() {
        return nombresyAp;
    }

    public void setNombresyAp(String nombresyAp) {
        this.nombresyAp = nombresyAp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCorreoRemi() {
        return correoRemi;
    }

    public void setCorreoRemi(String correoRemi) {
        this.correoRemi = correoRemi;
    }

    public String getClaveRemi() {
        return claveRemi;
    }

    public void setClaveRemi(String claveRemi) {
        this.claveRemi = claveRemi;
    }
    
    
    
    public void enviarMensaje(){
    
        try {
            
            this.enviaremail.setEmailRemitente(this.correoRemi);
            this.enviaremail.setPassRemitente(this.claveRemi);
            this.enviaremail.setEmailDestinatario("gourmetgenesis@gmail.com ");
            this.enviaremail.setNombresyAp(this.nombresyAp);
            this.enviaremail.setTelefono(this.telefono);
            this.enviaremail.setEmail(this.email);
            this.enviaremail.setAsunto(this.asunto);
            this.enviaremail.setMensaje(this.mensaje);
            
            this.enviaremail.enviarBasic();
            this.enviaremail.enviarAnswer();
            
            correoenvia = new Correo(null, this.correoRemi, this.asunto, this.mensaje, this.email, "SI", sc.getUsuario());
            cfl.create(correoenvia);
            MessageUtil.enviarMensajeInformacionGlobal("El correo ha sido enviado ", "El correo ha sido enviado satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    
    }
}
