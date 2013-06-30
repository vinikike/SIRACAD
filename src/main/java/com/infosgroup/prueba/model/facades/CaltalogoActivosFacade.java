/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Catalogoactivo;
import com.infosgroup.prueba.model.entities.CatalogoactivoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class CaltalogoActivosFacade extends AbstractFacade<Catalogoactivo, CatalogoactivoPK> {

    public CaltalogoActivosFacade() {
        super(Catalogoactivo.class);
    }
}
