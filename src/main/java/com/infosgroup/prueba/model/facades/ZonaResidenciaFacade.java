/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.ZonaResidencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class ZonaResidenciaFacade extends AbstractFacade<ZonaResidencia, String> {
    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaResidenciaFacade() {
        super(ZonaResidencia.class);
    }
    
}