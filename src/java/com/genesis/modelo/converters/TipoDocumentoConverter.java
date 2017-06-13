/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.converters;

import com.genesis.modelo.entities.Tipodocumento;
import com.genesis.modelo.facade.TipodocumentoFacade;
import com.genesis.modelo.facade.TipodocumentoFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Tipodocumento.class, value = "tipoDocumentoConverter")
public class TipoDocumentoConverter implements Converter{
    
    private TipodocumentoFacadeLocal tdfl;

    public TipoDocumentoConverter() {
        tdfl = CDI.current().select(TipodocumentoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tdfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Tipodocumento){
            Tipodocumento td = (Tipodocumento) value;
            return td.getId().toString();
        }
        return null;
    }
    
}
