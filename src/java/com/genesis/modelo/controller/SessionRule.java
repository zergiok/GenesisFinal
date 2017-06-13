/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;

import com.genesis.modelo.entities.Rol;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacadeLocal;
import com.genesis.modelo.controller.util.MessageUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author zergiok
 */
@Stateless
public class SessionRule {

    @EJB
    private UsuarioFacadeLocal ufl;

    public Usuario iniciar(Long cedula, String clave) {
        Usuario u = null;
        if (cedula != null && cedula > 0
                && clave != null && clave.length() > 0) {
            u = ufl.login(cedula, clave);
            if (u != null) {
                if (u.getEstado() == 2) {
                    u = null;
                    MessageUtil.enviarMensajeErrorGlobal(
                            "Usuario Bloqueado",
                            "Contacte al administrador.");

                }
            } else {
                MessageUtil.enviarMensajeErrorGlobal(
                        "Datos Invalidos",
                        "Documento y/o clave erroneos");
                
            }
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Datos Requeridos",
                    "Documento y/o clave son necesarios");
        }
        return u;
    }

    public Rol validarRol(Usuario u) {
        Rol r = null;
        if (u.getRolesusuario()!= null && u.getRolesusuario().size() > 0) {
            r = u.getRolesusuario().get(0).getIdRol();
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Rol no asignado",
                    "Contacte al administrador");
        }
        return r;
    }

}
