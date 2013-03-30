/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Libro;
import com.infosgroup.prueba.model.entities.LibroPK;
import javax.ejb.Stateless;

/**
 *
 * @author Guille
 */
@Stateless
public class InventarioDeLibrosFacade extends AbstractFacade<Libro, LibroPK> {

    public InventarioDeLibrosFacade() {
        super(Libro.class);
    }
}
