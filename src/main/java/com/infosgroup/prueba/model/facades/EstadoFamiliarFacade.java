/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.EstadoFamiliar;
import com.infosgroup.prueba.model.entities.EstadoFamiliarPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class EstadoFamiliarFacade extends AbstractFacade<EstadoFamiliar, EstadoFamiliarPK> {
    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFamiliarFacade() {
        super(EstadoFamiliar.class);
    }
    
}
