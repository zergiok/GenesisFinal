/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;

import com.genesis.modelo.entities.Tipo;
import com.genesis.modelo.facade.TipoFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mateo
 */
@FacesConverter(forClass = Tipo.class, value = "tipoProductoConverter")
public class TipoProductoConverter implements Converter{
    
    private TipoFacadeLocal tpfl;

    public TipoProductoConverter() {
        tpfl = CDI.current().select(TipoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tpfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Tipo){
            Tipo tp = (Tipo) value;
            return tp.getIdTipo().toString();
        }
        return null;
    }
    
}
