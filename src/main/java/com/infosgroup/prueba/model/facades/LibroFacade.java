/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Catalogolibros;
import com.infosgroup.prueba.model.entities.Libro;
import com.infosgroup.prueba.model.entities.LibroPK;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro, LibroPK> {

    public LibroFacade() {
        super(Libro.class);
    }
    
    public Long cantidadLibros(Catalogolibros c)
    {
        TypedQuery<Long> tq = getEntityManager().createQuery("SELECT MAX(l.libroPK.codigo) FROM Libro l WHERE l.", Long.class);
        return tq.getSingleResult();
    }
}
