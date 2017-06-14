/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.producto.modelo.controller;


import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Producto;
import com.genesis.modelo.facade.ProductoFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mateo
 */
@Named(value = "registroPedidoController")
@RequestScoped
public class RegistroProductoController {

    @EJB
    private ProductoFacadeLocal ufl;
   
    
    private Producto nuevoProducto;
    /**
     * Creates a new instance of RegistroController
     */
    public RegistroProductoController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoProducto = new Producto();
    }

    public Producto getNuevoProducto() {
        return nuevoProducto;
    }

    public void setNuevoProducto(Producto nuevoProducto) {
        this.nuevoProducto = nuevoProducto;
    }
    
    public void registrar(){
        if(nuevoProducto != null){
            ufl.create(nuevoProducto);
            MessageUtil.enviarMensajeInformacion("form-registro", "Registro satisfactorio", "El producto se ha registrado correctamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError("form-registro", "No se han diligenciado los campos", "");
        }
    }
    
}
