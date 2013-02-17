/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Autorizacion;
import com.infosgroup.prueba.model.entities.AutorizacionPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class AutorizacionFacade extends AbstractFacade<Autorizacion, AutorizacionPK> {
    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorizacionFacade() {
        super(Autorizacion.class);
    }
    
}
