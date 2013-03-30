/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Catalogolibros;
import com.infosgroup.prueba.model.entities.CatalogolibrosPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class CaltalogoLibrosFacade extends AbstractFacade<Catalogolibros, CatalogolibrosPK> {

    public CaltalogoLibrosFacade() {
        super(Catalogolibros.class);
    }
}
