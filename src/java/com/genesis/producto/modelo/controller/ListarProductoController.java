/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.producto.modelo.controller;

import com.genesis.modelo.controller.util.MessageUtil;
import com.genesis.modelo.entities.Producto;
import com.genesis.modelo.facade.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Mateo
 */
@Named(value = "listarProductosController")
@ViewScoped
public class ListarProductoController implements Serializable {

    @EJB
    private ProductoFacadeLocal ufl;

    private List<Producto> productos;

    private Producto productoSeleccionado;

    /**
     * Creates a new instance of ListarProductosController
     */
    public ListarProductoController() {
    }

    @PostConstruct
    public void init() {
        recargarProductos();
    }

    private void recargarProductos() {
        productos = ufl.findAll();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public ProductoFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(ProductoFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        System.out.println("hdjsahjdhsajkdhjksahd - " + productoSeleccionado.getIdProducto());
        this.productoSeleccionado = productoSeleccionado;
    }

    public void eliminarProducto() {
        Producto producto = null;
//        System.out.println("Voy a eliminar el producto: " + productoSeleccionado.getPrimerNombre());
        ufl.remove(productoSeleccionado);
        recargarProductos();
        MessageUtil.enviarMensajeInformacion("listar-productos", "Eliminacion correcta", "El producto se ha eliminado correctamente.");
    }
}
