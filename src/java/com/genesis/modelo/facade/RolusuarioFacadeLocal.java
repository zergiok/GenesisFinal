/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.facade;

import com.genesis.modelo.entities.Rolusuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zergiok
 */
@Local
public interface RolusuarioFacadeLocal {

    void create(Rolusuario rolusuario);

    void edit(Rolusuario rolusuario);

    void remove(Rolusuario rolusuario);

    Rolusuario find(Object id);

    List<Rolusuario> findAll();

    List<Rolusuario> findRange(int[] range);

    int count();
    
}
